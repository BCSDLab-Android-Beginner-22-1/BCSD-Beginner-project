package com.example.bcsd_weather.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcsd_weather.R
import com.example.bcsd_weather.adapter.ForecastAdapter
import com.example.bcsd_weather.databinding.ActivityForecastBinding
import com.example.bcsd_weather.viewmodel.ForecastViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForecastActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForecastBinding
    private val forecastAdapter = ForecastAdapter()
    private val forecastViewModel: ForecastViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forecast)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.lifecycleOwner = this

        forecastViewModel.setLocation(
            intent.getStringExtra("name"),
            intent.getIntExtra("x", 0),
            intent.getIntExtra("y", 0)
        )

        binding.forecastRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = forecastAdapter
        }

        forecastAdapter.setOnClickListener {
            val intent = Intent(this, DayForecastActivity::class.java)
            intent.putExtra("date", it)
            intent.putExtra("name", forecastViewModel.nowLocation.value!!.title)
            intent.putExtra("x", forecastViewModel.nowLocation.value!!.x)
            intent.putExtra("y", forecastViewModel.nowLocation.value!!.y)
            startActivity(intent)
        }

        forecastViewModel.forecastData.observe(this) {
            forecastAdapter.submitList(it)
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