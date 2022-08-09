package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.repository.GPSRepository
import kotlinx.coroutines.flow.Flow

class InitGPSLocation(private val gpsRepository: GPSRepository) {
    suspend operator fun invoke(): Flow<Boolean> {
        return gpsRepository.initGPSLocation()
    }
}