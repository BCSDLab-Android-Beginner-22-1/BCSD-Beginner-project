package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.datasource.UltraShortTermFcstDataSource
import com.example.bcsd_weather.data.model.mapToUltraShortTermForecast
import com.example.bcsd_weather.domain.model.UltraShortTermForecast
import com.example.bcsd_weather.domain.repository.UltraSrtFcstRepository

class UltraSrtFcstRepositoryImpl(private val ultraShortTermFcstDataSource: UltraShortTermFcstDataSource) :
    UltraSrtFcstRepository {
    override suspend fun getUltraSrtFcst(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): ArrayList<UltraShortTermForecast> {
        return ultraShortTermFcstDataSource.getUltraShortTermFcst(
            serviceKey,
            numOfRows,
            pageNo,
            dataType,
            baseDate,
            baseTime,
            nx,
            ny
        ).mapToUltraShortTermForecast()
    }
}