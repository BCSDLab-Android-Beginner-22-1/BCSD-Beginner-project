package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.TempData
import com.example.bcsd_weather.domain.repository.TempRepository

class GetTempUseCase(private val tempRepository: TempRepository) {
    suspend operator fun invoke(findDate: String, x: Int, y : Int) : List<TempData> =
        tempRepository.getTempData(findDate, x, y)
}