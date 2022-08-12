package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.UltraShortTermForecast

interface UltraSrtFcstRepository {
    suspend fun getUltraSrtFcst(nx: Int, ny: Int): ArrayList<UltraShortTermForecast>
}