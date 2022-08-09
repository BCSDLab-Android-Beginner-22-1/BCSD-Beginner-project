package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.GPS
import kotlinx.coroutines.flow.Flow

interface GPSRepository {
    suspend fun initGPSLocation(): Flow<Boolean>
    fun getGPSLocation(): GPS
}