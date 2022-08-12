package com.example.bcsd_weather.data.datasource

import com.example.bcsd_weather.data.api.RetrofitBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.bcsd_weather.data.model.UltraShortTermLiveRemote

class UltraShortTermLiveDataSourceImpl: UltraShortTermLiveDataSource {
    override fun getUltraShortTermLive(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): Flow<UltraShortTermLiveRemote>
    = flow {
        emit(
            RetrofitBuilder
        .ultraShortTermLiveService()
        .getWeather(serviceKey, numOfRows, pageNo, dataType, baseDate, baseTime, nx, ny))
    }
}