package com.example.bcsd_weather.domain.repository


import com.example.bcsd_weather.domain.model.CurrentWeather

interface CurrentWeatherRepository {
    suspend fun insertCurrentWeather(currentWeather: CurrentWeather, x: Int, y: Int)

    suspend fun deleteCurrentWeather(currentWeather: CurrentWeather, x: Int, y: Int)

    fun getCurrentWeather(x: Int, y: Int): List<CurrentWeather>

}