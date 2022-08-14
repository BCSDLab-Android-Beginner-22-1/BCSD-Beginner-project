package com.example.bcsd_weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.bcsd_weather.databinding.ActivityMainBinding
import com.example.bcsd_weather.domain.model.CurrentWeather
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val currentWeatherViewModel: CurrentWeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val ex = CurrentWeather("32","pre","hu","wind","1100")
        val ex2 = CurrentWeather("33","pre","hu","wind","1100")
        currentWeatherViewModel.insert(ex)
        currentWeatherViewModel.insert(ex2)

        CoroutineScope(Dispatchers.IO).launch{
            val data = currentWeatherViewModel.getCurrentWeather()
            binding.textview.text = data.toString()
        }
    }

}