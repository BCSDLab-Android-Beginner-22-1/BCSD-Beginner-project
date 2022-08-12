package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.ShortTermForecast
import com.example.bcsd_weather.domain.repository.ShortTermFcstRepository

class GetShortTermFcstUseCase(private val shortTermFcstRepository: ShortTermFcstRepository) {
    suspend fun excute(serviceKey: String,
                       numOfRows: Int,
                       pageNo: Int,
                       dataType: String,
                       baseDate: String,
                       baseTime: String,
                       nx: Int,
                       ny: Int): ShortTermForecast
    = shortTermFcstRepository.getShortTermFcst(
        serviceKey,
        numOfRows,
        pageNo,
        dataType,
        baseDate,
        baseTime,
        nx,
        ny
    )
}