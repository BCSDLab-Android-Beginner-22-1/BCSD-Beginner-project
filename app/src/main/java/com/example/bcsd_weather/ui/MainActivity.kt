package com.example.bcsd_weather.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcsd_weather.R
import com.example.bcsd_weather.adapter.NavDrawerAdapter
import com.example.bcsd_weather.adapter.TodayForecastAdapter
import com.example.bcsd_weather.databinding.ActivityMainBinding
import com.example.bcsd_weather.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val todayForecastAdapter = TodayForecastAdapter()
    private val navDrawerAdapter = NavDrawerAdapter()
    private val mainViewModel: MainViewModel by viewModel()

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
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}