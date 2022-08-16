package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.CurrentWeather
import com.example.bcsd_weather.domain.repository.CurrentWeatherRepository

class GetCurrentWeatherUseCase(private val currentWeatherRepository: CurrentWeatherRepository) {
    operator fun invoke(): List<CurrentWeather> = currentWeatherRepository.getCurrentWeather()
}