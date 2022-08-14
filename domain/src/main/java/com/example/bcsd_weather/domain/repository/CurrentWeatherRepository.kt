package com.example.bcsd_weather.domain.repository


import com.example.bcsd_weather.domain.model.CurrentWeather

interface CurrentWeatherRepository {
    suspend fun insert(currentWeather: CurrentWeather)

    suspend fun delete(currentWeather: CurrentWeather)


    fun getCurrentWeather(): List<CurrentWeather>

}