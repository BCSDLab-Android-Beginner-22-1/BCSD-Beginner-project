package com.example.bcsd_weather.data.datasource

import com.example.bcsd_weather.data.api.RetrofitBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.bcsd_weather.data.model.ShortTermForecastRemote

class ShortTermForecastDataSourceImpl: ShortTermForecastDataSource {
    override fun getShortTermFcst(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): Flow<ShortTermForecastRemote>
    = flow {
        emit(
            RetrofitBuilder
        .shortTermFcstService()
        .getWeather(serviceKey, numOfRows, pageNo, dataType, baseDate, baseTime, nx, ny))
    }
}