package com.example.bcsd_weather

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bcsd_weather.data.FutureWeatherEntity
import com.example.bcsd_weather.databinding.ActivityMainBinding
import com.example.bcsd_weather.db.future.FutureWeatherViewModel
import com.example.bcsd_weather.db.future.FutureWeatherViewModelFactory
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //    private lateinit var weatherViewModel: WeatherViewModel
    private lateinit var futureWeatherViewModel: FutureWeatherViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//
//        weatherViewModel = ViewModelProvider(this, WeatherViewModelFactory(application)).get(
//            WeatherViewModel::class.java)
//        binding.weatherViewModel = weatherViewModel
//
//         현재 날씨 데이터 observe
//        weatherViewModel.getAllWeather().observe(this, Observer {
//            // updateWeatherList(it) -> 메뉴에 날씨 추가
//        })
        // 예상 날씨 데이터 observe 코드
//        futureWeatherViewModel =
//            ViewModelProvider(this, FutureWeatherViewModelFactory(application)).get(
//                FutureWeatherViewModel::class.java)
//        futureWeatherViewModel.getFutureWeather(LocalDate.now()).observe(this, Observer {
//
//        })

    }

    //측면 메뉴 업데이트 함수
    fun updateWeatherList(futureWeatherList: List<FutureWeatherEntity>) {

    }

}