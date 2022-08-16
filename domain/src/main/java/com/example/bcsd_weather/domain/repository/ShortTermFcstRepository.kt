package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.ShortTermForecast
import com.example.bcsd_weather.domain.model.ShortTermTempForecast

interface ShortTermFcstRepository {
    suspend fun getShortTermFcst(nx: Int, ny: Int): List<ShortTermForecast>?
    suspend fun getShortTermTempFcst(nx: Int, ny: Int): List<ShortTermTempForecast>?
}