package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.CurrentWeather
import com.example.bcsd_weather.domain.repository.CurrentWeatherRepository

class GetCurrentWeatherUseCase(private val currentWeatherRepository: CurrentWeatherRepository) {
    suspend operator fun invoke(x: Int, y: Int): List<CurrentWeather> = currentWeatherRepository.getCurrentWeather(x,y)
}