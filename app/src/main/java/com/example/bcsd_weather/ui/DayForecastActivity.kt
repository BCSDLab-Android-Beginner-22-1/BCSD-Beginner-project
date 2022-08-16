package com.example.bcsd_weather.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcsd_weather.R
import com.example.bcsd_weather.adapter.DayForecastAdapter
import com.example.bcsd_weather.databinding.ActivityDayForecastBinding
import com.example.bcsd_weather.viewmodel.DayForecastViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DayForecastActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDayForecastBinding
    private val dayForecastAdapter = DayForecastAdapter()
    private val dayForecastViewModel: DayForecastViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_day_forecast)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.lifecycleOwner = this

        dayForecastViewModel.setLocation(
            intent.getStringExtra("name"),
            intent.getIntExtra("x", 0),
            intent.getIntExtra("y", 0)
        )

        dayForecastViewModel.setForecastDate(intent.getStringExtra("date")!!)

        binding.dayForecastRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = dayForecastAdapter
        }

        dayForecastViewModel.forecastData.observe(this) {
            dayForecastAdapter.submitList(it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}