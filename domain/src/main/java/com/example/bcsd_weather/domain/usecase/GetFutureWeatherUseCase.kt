package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository

class GetFutureWeatherUseCase(private val futureWeatherRepository: FutureWeatherRepository) {
    operator fun invoke(startDate: String): List<FutureWeather> =
        futureWeatherRepository.getFutureWeather(startDate)
}