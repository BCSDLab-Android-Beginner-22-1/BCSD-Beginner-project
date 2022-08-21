package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.repository.FutureWeatherRepository

class DeleteWeatherUseCase(private val futureWeatherRepository: FutureWeatherRepository) {
    suspend operator fun invoke(firstDateToKeep: String) =
        futureWeatherRepository.deleteWeather(firstDateToKeep)
}