package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository


class InsertFutureWeatherUseCase(private val futureWeatherRepository: FutureWeatherRepository) {
    suspend operator fun invoke(futureWeather: FutureWeather) =
        futureWeatherRepository.insertFutureWeather(futureWeather)
}