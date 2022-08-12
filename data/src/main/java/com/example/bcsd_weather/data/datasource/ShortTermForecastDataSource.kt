package com.example.bcsd_weather.data.datasource

import kotlinx.coroutines.flow.Flow
import com.example.bcsd_weather.data.model.ShortTermForecastRemote

interface ShortTermForecastDataSource {
    fun getShortTermFcst(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): ShortTermForecastRemote
}