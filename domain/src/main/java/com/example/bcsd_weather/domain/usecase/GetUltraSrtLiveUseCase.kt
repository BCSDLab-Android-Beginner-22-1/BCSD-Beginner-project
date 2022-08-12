package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.UltraShortTermLive
import com.example.bcsd_weather.domain.repository.UltraSrtLiveRepository

class GetUltraSrtLiveUseCase(private val ultraSrtLiveRepository: UltraSrtLiveRepository) {
    suspend fun execute(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): UltraShortTermLive = ultraSrtLiveRepository.getUltraSrtLive(
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