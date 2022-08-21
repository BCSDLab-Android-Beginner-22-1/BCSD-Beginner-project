package com.example.bcsd_weather.domain.repository

import com.example.bcsd_weather.domain.model.TempData

interface TempRepository {
    fun getAllTempData(x : Int, y : Int):List<TempData>

    suspend fun insertTempData(tempWeatherEntity: TempData)

    suspend fun deleteTempData(tempWeatherEntity: TempData)

    suspend fun getTempData(findDate : String, x : Int, y : Int):List<TempData>
}