package com.example.bcsd_weather.data.datasource

import com.example.bcsd_weather.data.api.RetrofitBuilder
import com.example.bcsd_weather.data.model.ShortTermForecastRemote

class ShortTermForecastDataSource {
    fun getShortTermFcst(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): ShortTermForecastRemote {
        return RetrofitBuilder
            .shortTermFcstService()
            .getWeather(serviceKey, numOfRows, pageNo, dataType, baseDate, baseTime, nx, ny)
    }
}