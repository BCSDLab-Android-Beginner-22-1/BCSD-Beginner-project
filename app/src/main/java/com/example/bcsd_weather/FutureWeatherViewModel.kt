package com.example.bcsd_weather

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.data.model.FutureWeatherLocal
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FutureWeatherViewModel(private val repository: FutureWeatherRepository) : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertFutureWeather(futureWeatherEntity: FutureWeatherLocal) {

        CoroutineScope(Dispatchers.IO).launch {
            repository.insertFutureWeather(futureWeatherEntity)
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getFutureWeather(startDate: String): LiveData<List<FutureWeatherLocal>> {
        return repository.getFutureWeather(startDate)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDetailedFutureWeather(date: String): LiveData<FutureWeatherLocal> {
        return repository.getDetailedFutureWeather(date)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun deleteWeather(firstDateToKeep: String) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteWeather(firstDateToKeep)
        }
    }
}