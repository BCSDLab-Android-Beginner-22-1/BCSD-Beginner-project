package com.example.bcsd_weather.data.datasource

import com.example.bcsd_weather.data.api.RetrofitBuilder
import com.example.bcsd_weather.data.model.UltraShortTermLiveRemote

class UltraShortTermLiveDataSource {
    fun getUltraShortTermLive(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): UltraShortTermLiveRemote {

        return RetrofitBuilder
            .ultraShortTermLiveService()
            .getWeather(serviceKey, numOfRows, pageNo, dataType, baseDate, baseTime, nx, ny)
    }
}