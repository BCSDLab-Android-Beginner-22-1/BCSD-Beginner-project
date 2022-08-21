package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.datasource.ShortTermForecastDataSource
import com.example.bcsd_weather.data.model.mapToShortTermForecast
import com.example.bcsd_weather.data.model.mapToTempData
import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.model.TempData
import com.example.bcsd_weather.domain.repository.ShortTermFcstRepository

class ShortTermFcstRepositoryImpl(private val shortTermForecastDataSource: ShortTermForecastDataSource) :
    ShortTermFcstRepository {
    override suspend fun getShortTermFcst(nx: Int, ny: Int): List<FutureWeather> {
        return shortTermForecastDataSource.getShortTermFcst(nx, ny).mapToShortTermForecast()
    }

    override suspend fun getShortTermTempFcst(nx: Int, ny: Int): List<TempData> {
        return shortTermForecastDataSource.getShortTermTempFcst(nx, ny).mapToTempData()
    }
}