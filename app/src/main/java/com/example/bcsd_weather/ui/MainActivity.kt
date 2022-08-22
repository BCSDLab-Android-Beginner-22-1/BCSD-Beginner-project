package com.example.bcsd_weather.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.location.Geocoder
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcsd_weather.R
import com.example.bcsd_weather.adapter.NavDrawerAdapter
import com.example.bcsd_weather.adapter.TodayForecastAdapter
import com.example.bcsd_weather.data.mapper.ConvertGPS
import com.example.bcsd_weather.databinding.ActivityMainBinding
import com.example.bcsd_weather.domain.model.LocalData
import com.example.bcsd_weather.util.OpenSettings
import com.example.bcsd_weather.view.GeocoderDialog
import com.example.bcsd_weather.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val todayForecastAdapter = TodayForecastAdapter()
    private val navDrawerAdapter = NavDrawerAdapter()
    private val mainViewModel: MainViewModel by viewModel()

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            when (isGranted) {
                true -> getGPSLocation()
                else -> {
                    when (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                        true -> permissionDialog(true)
                        else -> permissionDialog(false)
                    }
                }

            }
        }

    private val openSettings =
        registerForActivityResult(OpenSettings()) {
            checkPermission()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        checkNetworkConnection()

        binding.lifecycleOwner = this
        binding.contentMain.vm = mainViewModel

        setSupportActionBar(binding.toolbar)

        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_nav_menu)
        }

        checkPermission()

        binding.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        // Navigation drawer start

        binding.navContent.navDrawerRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = navDrawerAdapter
        }

        navDrawerAdapter.setOnClickListener {
            mainViewModel.changeLocation(it)
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }

        binding.navContent.currentLocationLayout.setOnClickListener {
            mainViewModel.setCurrentLocationToGPS()
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }

        binding.navContent.addLocationButton.setOnClickListener {
            val dialog = GeocoderDialog()
            dialog.setButtonClickListener(object : GeocoderDialog.OnButtonClickListener {
                override fun onButtonClicked() {
                    val locationName = dialog.binding.dialogAddressEditText.text.toString()
                    val geocoder = Geocoder(this@MainActivity, Locale.KOREA)

                    dialog.binding.dialogProgressBar.visibility = View.VISIBLE
                    try {
                        val add = geocoder.getFromLocationName(locationName, 1)

                        val x = add[0].latitude
                        val y = add[0].longitude

                        val convertGPS = ConvertGPS()
                        val converted = convertGPS.convertGPStoXY(x, y)

                        val input = LocalData(locationName, converted.x, converted.y)
                        mainViewModel.insertLocalData(input)
                        dialog.binding.dialogProgressBar.visibility = View.GONE
                        dialog.dismiss()
                    } catch (e: IndexOutOfBoundsException) {
                        dialog.binding.dialogProgressBar.visibility = View.GONE
                        dialog.dismiss()
                        Snackbar.make(
                            binding.root,
                            getString(R.string.geocoder_location_not_found, locationName),
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                    mainViewModel.getAllLocalData()
                }
            })
            dialog.show(supportFragmentManager, "GeocoderDialog")
        }

        mainViewModel.locationList.observe(this) {
            navDrawerAdapter.submitList(it)
        }

        // Navigation drawer end

        // Today forecast start

        binding.contentMain.todayForecastRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = todayForecastAdapter
        }

        mainViewModel.todayForecastList.observe(this) {
            todayForecastAdapter.submitList(it)
        }

        // Today forecast end

        binding.contentMain.forecastButton.setOnClickListener {
            val intent = Intent(this, ForecastActivity::class.java)
            intent.putExtra("name", mainViewModel.nowLocation.value!!.LocalName)
            intent.putExtra("x", mainViewModel.nowLocation.value!!.x)
            intent.putExtra("y", mainViewModel.nowLocation.value!!.y)
            startActivity(intent)
        }
    }

    private fun checkNetworkConnection() {
        if (!getNetworkState()) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.dialog_network_check_title))
                .setMessage(getString(R.string.dialog_network_check_message))
                .setPositiveButton(getString(R.string.dialog_network_check_finish)) { dialog, _ ->
                    dialog.dismiss()
                    finish()
                }
                .setCancelable(false)
            builder.show()
        }
    }

    private fun getNetworkState(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

    private fun checkPermission() {
        requestPermission.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
    }

    private fun permissionDialog(isDeniedOnce: Boolean) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.dialog_request_permission_title))
            .setMessage(getString(R.string.dialog_request_permission_message))
            .setPositiveButton(getString(R.string.dialog_request_permission_ok)) { dialog, _ ->
                when (isDeniedOnce) {
                    true -> checkPermission()
                    false -> openSettings.launch(null)
                }
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.dialog_request_permission_cancel)) { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
        builder.show()
    }

    private fun getGPSLocation() {
        mainViewModel.setCurrentLocationToGPS()
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}