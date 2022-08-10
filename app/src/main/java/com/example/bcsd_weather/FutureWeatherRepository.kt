package com.example.bcsd_weather.db.future

import androidx.lifecycle.LiveData
import com.example.bcsd_weather.data.FutureWeatherEntity

interface FutureWeatherRepository {
    fun insertFutureWeather(futureWeatherEntity: List<FutureWeatherEntity>)

    fun getFutureWeather(startDate: String): LiveData<List<FutureWeatherEntity>>

    fun getDetailedFutureWeather(date: String): LiveData<FutureWeatherEntity>

    fun deleteWeather(firstDateToKeep: String)
}