package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.TempData
import com.example.bcsd_weather.domain.repository.TempRepository

class GetTempUseCase(private val tempRepository: TempRepository) {
    operator fun invoke(findDate: String) : List<TempData> =
        tempRepository.getTempData(findDate)
}