package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.UltraShortTermForecast

interface UltraSrtFcstRepository {
    suspend fun getUltraSrtFcst(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int): ArrayList<UltraShortTermForecast>
}