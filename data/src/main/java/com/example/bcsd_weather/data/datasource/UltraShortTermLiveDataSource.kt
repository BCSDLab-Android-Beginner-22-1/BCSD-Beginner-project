package com.example.bcsd_weather.data.datasource

import com.example.bcsd_weather.data.api.RetrofitBuilder
import com.example.bcsd_weather.data.model.UltraShortTermLiveRemote
import com.example.bcsd_weather.domain.enums.ApiType
import com.example.bcsd_weather.domain.enums.getBaseDateAndTime

class UltraShortTermLiveDataSource {
    suspend fun getUltraShortTermLive(nx: Int, ny: Int): UltraShortTermLiveRemote {
        val baseDateAndTime = ApiType.UltraShortTermLive.getBaseDateAndTime()
        val baseDate = baseDateAndTime["baseDate"]!!
        val baseTime = baseDateAndTime["baseTime"]!!


        return RetrofitBuilder
            .ultraShortTermLiveService()
            .getWeather(baseDate = baseDate, baseTime = baseTime, nx = nx, ny = ny)
    }
}