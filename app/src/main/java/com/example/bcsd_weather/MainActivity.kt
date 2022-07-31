package com.example.bcsd_weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bcsd_weather.data.WeatherModel
import com.example.bcsd_weather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        weatherViewModel = ViewModelProvider(this,WeatherViewModelFactory(application)).get(WeatherViewModel::class.java)
//        binding.weatherViewModel = weatherViewModel

        weatherViewModel.getAll().observe(this, Observer {
            // updateWeatherList(it) -> 메뉴에 날씨 추가
        })

    }

    // 측면 메뉴 업데이트 함수
    fun updateWeatherList(weatherList: List<WeatherModel>){

    }
}