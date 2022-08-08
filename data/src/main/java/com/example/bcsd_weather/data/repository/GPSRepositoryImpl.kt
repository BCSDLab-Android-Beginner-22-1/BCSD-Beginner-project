package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.model.mapToGPS
import com.example.bcsd_weather.data.repository.remote.GPSRemoteDataSource
import com.example.bcsd_weather.domain.model.GPS
import com.example.bcsd_weather.domain.repository.GPSRepository

class GPSRepositoryImpl(private val gpsRemoteDataSource: GPSRemoteDataSource) : GPSRepository {
    override fun initGPSLocation() {
        return gpsRemoteDataSource.initGPS()
    }

    override fun getGPSLocation(): GPS? {
        return gpsRemoteDataSource.getGPS()?.mapToGPS()
    }
}