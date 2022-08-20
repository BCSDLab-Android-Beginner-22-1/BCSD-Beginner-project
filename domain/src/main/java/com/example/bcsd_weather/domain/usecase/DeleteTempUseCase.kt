package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.TempData
import com.example.bcsd_weather.domain.repository.TempRepository

class DeleteTempUseCase(private val tempRepository: TempRepository) {
    suspend operator fun invoke(tempData : TempData) =
        tempRepository.deleteTempData(tempData)
}