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

        val stF: ShortTermForecastModel = ShortTermForecastModel("32", "강수량", "습도", "풍속", "예보시각")
        val stitem: StITEM = StITEM("자료구분", "20220813", "fcsttime", "fcstvalue")

        val futureweatherentity: List<FutureWeatherEntity> =
            listOf(FutureWeatherEntity(stF, stitem))


//        val viewModel:FutureWeatherViewModel = ViewModelProvider(this).get(FutureWeatherViewModel::class.java)

        futureWeatherViewModel.deleteWeather("20220813")
        futureWeatherViewModel.insertFutureWeather(futureweatherentity)

        futureWeatherViewModel.getFutureWeather("20220813").observe(this, Observer {
//            Log.v(TAG, ">>> $it")
            binding.textview.text = it.toString()
        })


    }
}