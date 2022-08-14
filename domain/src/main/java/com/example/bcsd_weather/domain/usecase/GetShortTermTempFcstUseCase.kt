package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.ShortTermTempForecast
import com.example.bcsd_weather.domain.repository.ShortTermFcstRepository

class GetShortTermTempFcstUseCase(private val shortTermFcstRepository: ShortTermFcstRepository) {
    suspend operator fun invoke(nx: Int, ny: Int): ArrayList<ShortTermTempForecast>? =
        shortTermFcstRepository.getShortTermTempFcst(nx, ny)
}