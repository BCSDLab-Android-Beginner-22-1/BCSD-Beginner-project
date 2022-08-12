package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.ShortTermForecast

interface ShortTermFcstRepository {
    suspend fun getShortTermFcst(nx: Int, ny: Int): ArrayList<ShortTermForecast>
}