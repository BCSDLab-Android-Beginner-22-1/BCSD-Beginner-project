package com.example.bcsd_weather.data.repository.remote

import com.example.bcsd_weather.data.model.GPSRemote
import kotlinx.coroutines.flow.Flow

interface GPSRemoteDataSource {
    suspend fun initGPS(): Flow<Boolean>
    fun getGPS(): GPSRemote
}
