package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.datasource.UltraShortTermFcstDataSource
import com.example.bcsd_weather.data.model.mapToUltraShortTermForecast
import com.example.bcsd_weather.domain.model.UltraShortTermForecast
import com.example.bcsd_weather.domain.repository.UltraSrtFcstRepository

class UltraSrtFcstRepositoryImpl(private val ultraShortTermFcstDataSource: UltraShortTermFcstDataSource) :
    UltraSrtFcstRepository {
    override suspend fun getUltraSrtFcst(nx: Int, ny: Int): ArrayList<UltraShortTermForecast>? {
        return ultraShortTermFcstDataSource.getUltraShortTermFcst(nx, ny)
            .mapToUltraShortTermForecast()
    }
}