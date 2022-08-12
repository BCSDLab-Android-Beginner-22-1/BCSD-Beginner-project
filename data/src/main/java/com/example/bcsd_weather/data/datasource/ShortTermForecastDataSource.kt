package com.example.bcsd_weather.data.datasource

import com.example.bcsd_weather.data.api.RetrofitBuilder
import com.example.bcsd_weather.data.model.ShortTermForecastRemote
import com.example.bcsd_weather.domain.enum.ApiType
import com.example.bcsd_weather.domain.enum.getBaseDateAndTime

class ShortTermForecastDataSource {
    suspend fun getShortTermFcst(nx: Int, ny: Int): ShortTermForecastRemote {

        val baseDateAndTime = ApiType.ShortTermForecast.getBaseDateAndTime()
        val baseDate = baseDateAndTime["baseDate"]!!
        val baseTime = baseDateAndTime["baseTime"]!!

        return RetrofitBuilder
            .shortTermFcstService()
            .getWeather(baseDate = baseDate, baseTime = baseTime, nx = nx, ny = ny)
    }
}