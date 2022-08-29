package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.CurrentWeather
import com.example.bcsd_weather.domain.repository.UltraSrtFcstRepository

class GetUltraSrtFcstUseCase(private val ultraSrtFcstRepository: UltraSrtFcstRepository) {
    suspend operator fun invoke(nx: Int, ny: Int): List<CurrentWeather> =
        ultraSrtFcstRepository.getUltraSrtFcst(nx, ny)
}