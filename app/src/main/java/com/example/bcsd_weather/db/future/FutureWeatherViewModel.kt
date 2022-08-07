package com.example.bcsd_weather.db.future

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.bcsd_weather.data.FutureWeatherEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate

class FutureWeatherViewModel(application: Application):AndroidViewModel(application) {
    @RequiresApi(Build.VERSION_CODES.O)
    private val repository = FutureWeatherRepository(application)

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertFutureWeather(futureWeatherEntity: List<FutureWeatherEntity>){

        CoroutineScope(Dispatchers.IO).launch {
            repository.insertFutureWeather(futureWeatherEntity)
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getFutureWeather(startDate: LocalDate): LiveData<List<FutureWeatherEntity>> {
        return repository.getFutureWeather(startDate)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDetailedFutureWeather(date: LocalDate): LiveData<FutureWeatherEntity> {
        return repository.getDetailedFutureWeather(date)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun deleteWeather(firstDateToKeep: LocalDate){
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteWeather(firstDateToKeep)
        }
    }


}