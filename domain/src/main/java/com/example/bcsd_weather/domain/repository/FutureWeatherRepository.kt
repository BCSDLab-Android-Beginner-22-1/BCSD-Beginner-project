package com.example.bcsd_weather.domain.repository

import androidx.lifecycle.LiveData

import com.example.bcsd_weather.domain.model.FutureWeatherEntity

interface FutureWeatherRepository {
    suspend fun insertFutureWeather(futureWeatherEntity: List<FutureWeatherEntity>)

    fun getFutureWeather(startDate: String): LiveData<List<FutureWeatherEntity>>

    fun getDetailedFutureWeather(date: String): LiveData<FutureWeatherEntity>

    suspend fun deleteWeather(firstDateToKeep: String)
}