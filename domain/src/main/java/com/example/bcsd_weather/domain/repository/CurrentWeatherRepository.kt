package com.example.bcsd_weather.domain.repository

import androidx.lifecycle.LiveData
import com.example.bcsd_weather.data.WeatherModel

interface CurrentWeatherRepository {
    suspend fun insert(weather: WeatherModel)

    suspend fun delete(weather: WeatherModel)

    fun getIdWeather(): LiveData<WeatherModel>

    fun getAllWeather(): LiveData<List<WeatherModel>>

}