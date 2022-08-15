package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.UltraShortTermLive

interface UltraSrtLiveRepository {
    suspend fun getUltraSrtLive(nx: Int, ny: Int): UltraShortTermLive?
}