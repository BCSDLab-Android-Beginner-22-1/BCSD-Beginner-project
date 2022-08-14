package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.LocalData

interface LocalRepository {
    fun getAllLocalData():List<LocalData>

    suspend fun insertLocalData(localWeatherEntity: LocalData)

    suspend fun deleteAllLocalData()
}