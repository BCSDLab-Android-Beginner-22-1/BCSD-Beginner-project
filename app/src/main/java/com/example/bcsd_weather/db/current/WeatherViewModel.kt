package com.example.bcsd_weather.db.current

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.bcsd_weather.data.WeatherModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(application: Application): AndroidViewModel(application) {
    private val repository = WeatherRepository(application)


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