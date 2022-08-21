package com.example.bcsd_weather.data.mapper

import com.example.bcsd_weather.domain.model.TempData
import com.example.bcsd_weather.data.model.TempEntity

fun TempEntity.mapToTempData(x: Int = 0, y: Int = 0):TempData{
    return TempData(
        date,
        x,
        y,
        updateTime,
        maxTemperature,
        minTemperature
    )
}

fun TempData.mapToTempEntity(x: Int = 0, y: Int = 0):TempEntity{
    return TempEntity(
        date,
        x,
        y,
        updateTime,
        maxTemperature,
        minTemperature
    )
}