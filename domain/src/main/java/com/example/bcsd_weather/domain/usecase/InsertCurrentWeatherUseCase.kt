package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.CurrentWeather
import com.example.bcsd_weather.domain.repository.CurrentWeatherRepository

class InsertCurrentWeatherUseCase(private val currentWeatherRepository: CurrentWeatherRepository) {
    suspend operator fun invoke(currentWeather: CurrentWeather, x: Int, y: Int) =
        currentWeatherRepository.insertCurrentWeather(currentWeather, x, y)
}