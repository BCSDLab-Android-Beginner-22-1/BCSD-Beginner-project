package com.example.bcsd_weather

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.data.model.FutureWeatherEntity
import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FutureWeatherViewModel(private val repository: FutureWeatherRepository) : ViewModel() {

    fun insertFutureWeather(futureWeather: FutureWeather) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.insertFutureWeather(futureWeather)
        }
    }

    fun getFutureWeather(startDate: String): List<FutureWeather> {
        return repository.getFutureWeather(startDate)
    }

    fun getDetailedFutureWeather(date: String): FutureWeather {
        return repository.getDetailedFutureWeather(date)
    }

    fun deleteWeather(firstDateToKeep: String) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteWeather(firstDateToKeep)
        }
    }
}