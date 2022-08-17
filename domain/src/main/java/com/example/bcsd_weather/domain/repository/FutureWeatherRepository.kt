package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.FutureWeather

interface FutureWeatherRepository {
    suspend fun insertFutureWeather(futureWeather: FutureWeather)

    fun getFutureWeather(startDate: String): List<FutureWeather>

    fun getDetailedFutureWeather(date: String): List<FutureWeather>

    suspend fun deleteWeather(firstDateToKeep: String)

    fun getHighestTemp(date:String):FutureWeather

    fun getLowestTemp(date:String):FutureWeather
}