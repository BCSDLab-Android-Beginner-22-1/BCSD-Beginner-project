package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.GPS

interface GPSRepository {
    fun initGPSLocation()
    fun getGPSLocation(): GPS?
}