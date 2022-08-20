package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.TempData

interface TempRepository {
    fun getAllTempData():List<TempData>

    suspend fun insertTempData(tempWeatherEntity: TempData)

    suspend fun deleteTempData(tempWeatherEntity: TempData)

    fun getTempData(findDate : String):List<TempData>
}