package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.GPS
import com.example.bcsd_weather.domain.repository.GPSRepository

class GetGPSLocation(private val gpsRepository: GPSRepository) {
    operator fun invoke(): GPS? {
        return gpsRepository.getGPSLocation()
    }
}