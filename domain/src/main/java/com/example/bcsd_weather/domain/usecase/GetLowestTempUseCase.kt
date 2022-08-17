package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository

class GetLowestTempUseCase(private val futureWeatherRepository: FutureWeatherRepository) {
    operator fun invoke(date: String): FutureWeather =
        futureWeatherRepository.getLowestTemp(date)
}