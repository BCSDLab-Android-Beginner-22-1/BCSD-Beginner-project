package com.example.bcsd_weather.data.datasource

import com.example.bcsd_weather.data.api.RetrofitBuilder
import com.example.bcsd_weather.data.model.ShortTermForecastRemote
import com.example.bcsd_weather.domain.enums.ApiType
import com.example.bcsd_weather.domain.enums.getBaseDateAndTime

class ShortTermForecastDataSource {
    suspend fun getShortTermFcst(nx: Int, ny: Int): ShortTermForecastRemote {

        val baseDateAndTime = ApiType.ShortTermForecast.getBaseDateAndTime()
        val baseDate = baseDateAndTime["baseDate"]!!
        val baseTime = baseDateAndTime["baseTime"]!!

        return RetrofitBuilder
            .shortTermFcstService()
            .getWeather(baseDate = baseDate, baseTime = baseTime, nx = nx, ny = ny)
    }

    suspend fun getShortTermTempFcst(nx: Int, ny: Int): ShortTermForecastRemote {

        val baseDateAndTime = ApiType.ShortTermForecast.getBaseDateAndTime()
        val baseDate = baseDateAndTime["baseDate"]!!
        val baseTime = baseDateAndTime["baseTime"]!!

        // API only provide lowest temperature if baseTime is 0200.
        // So, hardcode baseTime to 0200 to get lowest temperature
        return RetrofitBuilder
            .shortTermFcstService()
            .getWeather(baseDate = baseDate, baseTime = "0200", nx = nx, ny = ny)
    }
}
