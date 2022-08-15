package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.datasource.UltraShortTermLiveDataSource
import com.example.bcsd_weather.data.model.mapToUltraShortTermLive
import com.example.bcsd_weather.domain.model.UltraShortTermLive
import com.example.bcsd_weather.domain.repository.UltraSrtLiveRepository

class UltraSrtLiveRepositoryImpl(private val ultraSrtTermLiveDataSource: UltraShortTermLiveDataSource) :
    UltraSrtLiveRepository {
    override suspend fun getUltraSrtLive(nx: Int, ny: Int): UltraShortTermLive? {
        return ultraSrtTermLiveDataSource.getUltraShortTermLive(nx, ny).mapToUltraShortTermLive()
    }
}