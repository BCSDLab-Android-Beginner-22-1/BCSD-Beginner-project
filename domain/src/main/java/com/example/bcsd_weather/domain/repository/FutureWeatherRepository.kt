package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.FutureWeather

interface FutureWeatherRepository {
    suspend fun insertFutureWeather(futureWeather: FutureWeather, x: Int, y: Int)

    suspend fun getDetailedFutureWeather(date: String, x: Int, y: Int): List<FutureWeather>

    suspend fun deleteWeather(firstDateToKeep: String)

}