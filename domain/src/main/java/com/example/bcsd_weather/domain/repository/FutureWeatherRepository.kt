package com.example.bcsd_weather.domain.repository

import androidx.lifecycle.LiveData

import com.example.bcsd_weather.domain.model.FutureWeatherEntity

interface FutureWeatherRepository {
    suspend fun insertFutureWeather(futureWeatherEntity: FutureWeatherEntity)

    fun getFutureWeather(startDate: String): List<FutureWeatherEntity>

    fun getDetailedFutureWeather(date: String): FutureWeatherEntity

    suspend fun deleteWeather(firstDateToKeep: String)
}