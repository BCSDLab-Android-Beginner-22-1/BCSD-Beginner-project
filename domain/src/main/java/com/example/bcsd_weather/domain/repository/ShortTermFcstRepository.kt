package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.model.TempData

interface ShortTermFcstRepository {
    suspend fun getShortTermFcst(nx: Int, ny: Int): List<FutureWeather>
    suspend fun getShortTermTempFcst(nx: Int, ny: Int): List<TempData>
}