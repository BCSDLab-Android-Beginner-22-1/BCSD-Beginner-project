package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.Location
import com.example.bcsd_weather.domain.repository.GPSRepository
import kotlinx.coroutines.flow.Flow

class GetGPSLocationUseCase(private val gpsRepository: GPSRepository) {
    suspend operator fun invoke(): Flow<Location> {
        return gpsRepository.getGPSLocation()
    }
}