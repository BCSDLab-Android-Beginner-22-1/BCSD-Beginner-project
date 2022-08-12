package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.datasource.ShortTermForecastDataSource
import com.example.bcsd_weather.data.model.mapToShortTermForecast
import com.example.bcsd_weather.data.model.mapToShortTermTempForecast
import com.example.bcsd_weather.domain.model.ShortTermForecast
import com.example.bcsd_weather.domain.model.ShortTermTempForecast
import com.example.bcsd_weather.domain.repository.ShortTermFcstRepository

class ShortTermFcstRepositoryImpl(private val shortTermForecastDataSource: ShortTermForecastDataSource) :
    ShortTermFcstRepository {
    override suspend fun getShortTermFcst(nx: Int, ny: Int): ArrayList<ShortTermForecast> {
        return shortTermForecastDataSource.getShortTermFcst(nx, ny).mapToShortTermForecast()
    }

    override suspend fun getShortTermTempFcst(nx: Int, ny: Int): ArrayList<ShortTermTempForecast> {
        return shortTermForecastDataSource.getShortTermTempFcst(nx, ny).mapToShortTermTempForecast()
    }
}