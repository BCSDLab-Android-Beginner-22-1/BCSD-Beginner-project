package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.UltraShortTermLive

interface UltraSrtLiveRepository {
    suspend fun getUltraSrtLive(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int): UltraShortTermLive
}