package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.CurrentWeather
import com.example.bcsd_weather.domain.repository.CurrentWeatherRepository

class DeleteCurrentWeatherUseCase(private val currentWeatherRepository: CurrentWeatherRepository) {
    suspend operator fun invoke(currentWeather: CurrentWeather, x: Int, y: Int) =
        currentWeatherRepository.deleteCurrentWeather(currentWeather,x,y)
}