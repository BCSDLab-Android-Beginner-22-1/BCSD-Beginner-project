package com.example.bcsd_weather.data.datasource

import com.example.bcsd_weather.data.api.RetrofitBuilder
import com.example.bcsd_weather.data.model.UltraShortTermForeCastRemote

class UltraShortTermFcstDataSource {
    fun getUltraShortTermFcst(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): UltraShortTermForeCastRemote {
        return RetrofitBuilder
            .ultraShortTermFcstService()
            .getWeather(serviceKey, numOfRows, pageNo, dataType, baseDate, baseTime, nx, ny)
    }
}