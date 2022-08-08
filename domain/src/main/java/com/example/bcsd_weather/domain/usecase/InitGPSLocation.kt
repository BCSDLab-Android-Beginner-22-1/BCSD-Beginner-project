package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.repository.GPSRepository

class InitGPSLocation(private val gpsRepository: GPSRepository) {
    operator fun invoke() {
        gpsRepository.initGPSLocation()
    }
}