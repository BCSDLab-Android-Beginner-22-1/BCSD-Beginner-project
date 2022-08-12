package com.example.bcsd_weather.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.data.WeatherModel
import com.example.bcsd_weather.data.repository.CurrentWeatherRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CurrentWeatherViewModel(val repository: CurrentWeatherRepositoryImpl): ViewModel() {

    // 새로운 날씨 정보 추가 (data binding)
    fun addWeather(weather: WeatherModel){

        CoroutineScope(Dispatchers.IO).launch {
            repository.insert(weather)
        }
    }

    fun getIdWeather(): LiveData<WeatherModel> {
        return repository.getIdWeather()
    }


    fun getAllWeather() : LiveData<List<WeatherModel>> {
        return repository.getAllWeather()
    }


}