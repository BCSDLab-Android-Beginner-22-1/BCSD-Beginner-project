package com.example.bcsd_weather.db.future

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.data.FutureWeatherEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FutureWeatherViewModel(private val repository: FutureWeatherRepository) : ViewModel() {

    fun insertFutureWeather(futureWeatherEntity: List<FutureWeatherEntity>) {

        CoroutineScope(Dispatchers.IO).launch {
            repository.insertFutureWeather(futureWeatherEntity)
        }

    }

    fun getFutureWeather(startDate: String): LiveData<List<FutureWeatherEntity>> {
        return repository.getFutureWeather(startDate)
    }

    fun getDetailedFutureWeather(date: String): LiveData<FutureWeatherEntity> {
        return repository.getDetailedFutureWeather(date)
    }

    fun deleteWeather(firstDateToKeep: String) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteWeather(firstDateToKeep)
        }
    }


}