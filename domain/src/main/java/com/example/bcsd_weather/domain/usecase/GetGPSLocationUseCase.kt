package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.Location
import com.example.bcsd_weather.domain.repository.GPSRepository

class GetGPSLocationUseCase(private val gpsRepository: GPSRepository) {
    operator fun invoke(): Location {
        return gpsRepository.getGPSLocation()
    }
}