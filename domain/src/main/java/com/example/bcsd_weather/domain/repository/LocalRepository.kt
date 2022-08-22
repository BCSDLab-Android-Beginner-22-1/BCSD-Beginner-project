package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.LocalData

interface LocalRepository {
    fun getAllLocalData(): List<LocalData>

    suspend fun insertLocalData(localData: LocalData)

    suspend fun deleteLocalData(localData: LocalData)
}