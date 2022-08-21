package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.TempData
import com.example.bcsd_weather.domain.repository.TempRepository

class GetAllTempUseCase(private val tempRepository: TempRepository) {
    operator fun invoke(x : Int, y : Int) : List<TempData> =
        tempRepository.getAllTempData(x, y)
}