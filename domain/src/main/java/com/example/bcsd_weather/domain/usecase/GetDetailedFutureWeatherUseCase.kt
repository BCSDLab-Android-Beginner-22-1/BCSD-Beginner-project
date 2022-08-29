package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository

class GetDetailedFutureWeatherUseCase(private val futureWeatherRepository: FutureWeatherRepository) {
    suspend operator fun invoke(date: String, x: Int, y: Int): List<FutureWeather> =
        futureWeatherRepository.getDetailedFutureWeather(date, x, y)
}