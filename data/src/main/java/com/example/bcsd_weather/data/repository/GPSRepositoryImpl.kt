package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.datasource.remote.GPSRemoteDataSource
import com.example.bcsd_weather.data.mapper.ConvertGPS
import com.example.bcsd_weather.data.model.mapToGPS
import com.example.bcsd_weather.domain.model.Location
import com.example.bcsd_weather.domain.repository.GPSRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class GPSRepositoryImpl(
    private val gpsRemoteDataSource: GPSRemoteDataSource,
    private val convertGPS: ConvertGPS
) : GPSRepository {
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

    override fun getGPSLocation(): Location {
        return gpsRemoteDataSource.getGPS().mapToGPS(convertGPS)
    }
}