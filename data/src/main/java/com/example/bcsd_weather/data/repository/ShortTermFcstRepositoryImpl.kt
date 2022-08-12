package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.datasource.ShortTermForecastDataSource
import com.example.bcsd_weather.data.model.mapToShortTermForecast
import com.example.bcsd_weather.domain.model.ShortTermForecast
import com.example.bcsd_weather.domain.repository.ShortTermFcstRepository

class ShortTermFcstRepositoryImpl(private val shortTermForecastDataSource: ShortTermForecastDataSource) :
    ShortTermFcstRepository {
    override suspend fun getShortTermFcst(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): ArrayList<ShortTermForecast> {
        return shortTermForecastDataSource.getShortTermFcst(
            serviceKey,
            numOfRows,
            pageNo,
            dataType,
            baseDate,
            baseTime,
            nx,
            ny
        ).mapToShortTermForecast()
    }
}