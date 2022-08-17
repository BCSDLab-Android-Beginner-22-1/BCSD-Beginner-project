package com.example.bcsd_weather.ui

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcsd_weather.R
import com.example.bcsd_weather.adapter.NavDrawerAdapter
import com.example.bcsd_weather.adapter.TodayForecastAdapter
import com.example.bcsd_weather.databinding.ActivityMainBinding
import com.example.bcsd_weather.util.OpenSettings
import com.example.bcsd_weather.view.GeocoderDialog
import com.example.bcsd_weather.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val todayForecastAdapter = TodayForecastAdapter()
    private val navDrawerAdapter = NavDrawerAdapter()
    private val mainViewModel: MainViewModel by viewModel()

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { results ->
            for (result in results) {
                when (result.value) {
                    true -> getGPSLocation()
                    else -> {
                        when (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION) ||
                                shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                            true -> permissionDialog(true)
                            else -> permissionDialog(false)
                        }
                        break
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
            setHasFixedSize(true)
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
            intent.putExtra("name", mainViewModel.nowLocation.value!!.title)
            intent.putExtra("x", mainViewModel.nowLocation.value!!.x)
            intent.putExtra("y", mainViewModel.nowLocation.value!!.y)
            startActivity(intent)
        }
    }

    private fun checkPermission() {
        val permissionList = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

        requestPermission.launch(permissionList)
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

    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}