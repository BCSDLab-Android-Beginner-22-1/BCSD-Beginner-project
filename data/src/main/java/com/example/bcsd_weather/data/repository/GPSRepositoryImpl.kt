package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.model.mapToGPS
import com.example.bcsd_weather.data.repository.remote.GPSRemoteDataSource
import com.example.bcsd_weather.domain.model.GPS
import com.example.bcsd_weather.domain.repository.GPSRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class GPSRepositoryImpl(private val gpsRemoteDataSource: GPSRemoteDataSource) : GPSRepository {
    override suspend fun initGPSLocation(): Flow<Boolean> {
        return flow {
            gpsRemoteDataSource.initGPS()
                .catch {
                    println(it)
                }
                .collect {
                    emit(it)
                }
        }
    }

    override fun getGPSLocation(): GPS {
        return gpsRemoteDataSource.getGPS().mapToGPS()
    }
}