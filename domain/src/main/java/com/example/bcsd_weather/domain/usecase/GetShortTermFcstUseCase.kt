package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.ShortTermForecast
import com.example.bcsd_weather.domain.repository.ShortTermFcstRepository

class GetShortTermFcstUseCase(private val shortTermFcstRepository: ShortTermFcstRepository) {
    suspend operator fun invoke(nx: Int, ny: Int): ArrayList<ShortTermForecast>? =
        shortTermFcstRepository.getShortTermFcst(nx, ny)
}