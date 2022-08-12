package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.UltraShortTermForecast
import com.example.bcsd_weather.domain.repository.UltraSrtFcstRepository

class GetUltraSrtFcstUseCase(private val ultraSrtFcstRepository: UltraSrtFcstRepository) {
    suspend operator fun invoke(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): ArrayList<UltraShortTermForecast> = ultraSrtFcstRepository.getUltraSrtFcst(
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