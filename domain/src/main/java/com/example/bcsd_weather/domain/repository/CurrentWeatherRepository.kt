package com.example.bcsd_weather.domain.repository


import com.example.bcsd_weather.domain.model.CurrentWeather

interface CurrentWeatherRepository {
    suspend fun insertCurrentWeather(currentWeather: CurrentWeather)

    suspend fun deleteCurrentWeather(currentWeather: CurrentWeather)

    fun getCurrentWeather(): List<CurrentWeather>

}