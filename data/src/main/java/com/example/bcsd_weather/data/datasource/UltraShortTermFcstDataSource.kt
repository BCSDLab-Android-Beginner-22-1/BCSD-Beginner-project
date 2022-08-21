package com.example.bcsd_weather.data.datasource

import com.example.bcsd_weather.data.api.RetrofitBuilder
import com.example.bcsd_weather.data.model.UltraShortTermForeCastRemote
import com.example.bcsd_weather.domain.enums.ApiType
import com.example.bcsd_weather.domain.enums.getBaseDateAndTime

class UltraShortTermFcstDataSource {
    suspend fun getUltraShortTermFcst(nx: Int, ny: Int): UltraShortTermForeCastRemote {
        val baseDateAndTime = ApiType.UltraShortTermForecast.getBaseDateAndTime()
        val baseDate = baseDateAndTime["baseDate"]!!
        val baseTime = baseDateAndTime["baseTime"]!!


        return RetrofitBuilder
            .ultraShortTermFcstService()
            .getWeather(baseDate = baseDate, baseTime = baseTime, nx = nx, ny = ny)
    }
}