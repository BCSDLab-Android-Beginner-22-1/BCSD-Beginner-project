package com.example.bcsd_weather

import android.content.ContentValues.TAG
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bcsd_weather.databinding.ActivityMainBinding
import com.example.bcsd_weather.domain.model.FutureWeatherEntity
import com.example.bcsd_weather.domain.model.ShortTermForecastModel
import com.example.bcsd_weather.domain.model.StITEM
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: FutureWeatherViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val stF: ShortTermForecastModel = ShortTermForecastModel("32", "강수량", "습도", "풍속", "예보시각")
        val stitem: StITEM = StITEM("자료구분", "20220813", "fcsttime", "fcstvalue")

        val futureweatherentity: List<FutureWeatherEntity> =
            listOf(FutureWeatherEntity(stF, stitem))


//        val viewModel:FutureWeatherViewModel = ViewModelProvider(this).get(FutureWeatherViewModel::class.java)

        viewModel.deleteWeather("20220813")
        viewModel.insertFutureWeather(futureweatherentity)

        viewModel.getFutureWeather("20220813").observe(this, Observer {
//            Log.v(TAG, ">>> $it")
            binding.textview.text = it.toString()
        })


    }
}