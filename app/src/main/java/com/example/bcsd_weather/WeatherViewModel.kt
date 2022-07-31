package com.example.bcsd_weather

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bcsd_weather.data.WeatherModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(application: Application): AndroidViewModel(application) {
    private val repository = WeatherRepository(application)


    // 새로운 날짜정보 추가
    fun addWeather(weather: WeatherModel){

        CoroutineScope(Dispatchers.IO).launch {
            repository.insert(weather)
        }
    }

    fun getAll() : LiveData<List<WeatherModel>> {
        return repository.getAll()
    }


}