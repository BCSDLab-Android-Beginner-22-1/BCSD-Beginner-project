package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.datasource.UltraShortTermFcstDataSource
import com.example.bcsd_weather.data.model.mapToUltraShortTermForecast
import com.example.bcsd_weather.domain.model.CurrentWeather
import com.example.bcsd_weather.domain.repository.UltraSrtFcstRepository

class UltraSrtFcstRepositoryImpl(private val ultraShortTermFcstDataSource: UltraShortTermFcstDataSource) :
    UltraSrtFcstRepository {
    override suspend fun getUltraSrtFcst(nx: Int, ny: Int): List<CurrentWeather> {
        return ultraShortTermFcstDataSource.getUltraShortTermFcst(nx, ny)
            .mapToUltraShortTermForecast()
    }
}