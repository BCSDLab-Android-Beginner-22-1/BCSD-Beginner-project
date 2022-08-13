package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.FutureWeather

interface FutureWeatherRepository {
    suspend fun insertFutureWeather(futureWeather: FutureWeather)

    fun getFutureWeather(startDate: String): List<FutureWeather>

    fun getDetailedFutureWeather(date: String): FutureWeather

    suspend fun deleteWeather(firstDateToKeep: String)
}