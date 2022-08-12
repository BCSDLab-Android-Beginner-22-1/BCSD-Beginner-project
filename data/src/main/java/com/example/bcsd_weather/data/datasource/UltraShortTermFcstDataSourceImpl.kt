package com.example.bcsd_weather.data.datasource

import com.example.bcsd_weather.data.api.RetrofitBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.bcsd_weather.data.model.UltraShortTermForeCastRemote

class UltraShortTermFcstDataSourceImpl: UltraShortTermFcstDataSource {
    override fun getUltraShortTermFcst(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): Flow<UltraShortTermForeCastRemote>
    = flow {
        emit(
            RetrofitBuilder
            .ultraShortTermFcstService()
            .getWeather(serviceKey, numOfRows, pageNo, dataType, baseDate, baseTime, nx, ny))
    }
}