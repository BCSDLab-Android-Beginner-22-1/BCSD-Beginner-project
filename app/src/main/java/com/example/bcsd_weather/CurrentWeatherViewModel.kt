package com.example.bcsd_weather


import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.CurrentWeather
import com.example.bcsd_weather.domain.repository.CurrentWeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CurrentWeatherViewModel(private val repository: CurrentWeatherRepository) : ViewModel() {

    fun insert(weather: CurrentWeather) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.insert(weather)
        }
    }

    fun delete(weather: CurrentWeather){
        CoroutineScope(Dispatchers.IO).launch {
            repository.delete(weather)
        }
    }


    fun getCurrentWeather(): List<CurrentWeather> {
        return repository.getCurrentWeather()
    }


}