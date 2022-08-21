package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.CurrentWeather

interface UltraSrtFcstRepository {
    suspend fun getUltraSrtFcst(nx: Int, ny: Int): List<CurrentWeather>
}