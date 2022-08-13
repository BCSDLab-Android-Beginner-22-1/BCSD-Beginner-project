package com.example.bcsd_weather

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.bcsd_weather.databinding.ActivityMainBinding
import com.example.bcsd_weather.domain.model.FutureWeatherEntity
import com.example.bcsd_weather.domain.model.ShortTermForecastModel
import com.example.bcsd_weather.domain.model.StITEM
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val futureWeatherViewModel: FutureWeatherViewModel by viewModel()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val ex = FutureWeatherEntity("tmp2","pre","hum","wind","fcstt","cate","2022-08-13","fcstvalue")
        val ex2 = FutureWeatherEntity("tmp33","pre","hum","wind","fcstt","cate","2022-08-13","fcstvalue")
        val ex3 = FutureWeatherEntity("tmp44","pre","hum","wind","fcstt","cate","2022-08-13","fcstvalue")
        futureWeatherViewModel.insertFutureWeather(ex)
        futureWeatherViewModel.insertFutureWeather(ex2)
        futureWeatherViewModel.insertFutureWeather(ex3)

        futureWeatherViewModel.getFutureWeather("2022-08-13").observe(this, Observer {
            binding.textview.text = it.toString()
        })


    }
}