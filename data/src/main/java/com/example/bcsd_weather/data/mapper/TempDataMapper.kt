package com.example.bcsd_weather.data.mapper

import com.example.bcsd_weather.domain.model.TempData
import com.example.bcsd_weather.data.model.TempEntity

fun TempEntity.mapToTempData():TempData{
    return TempData(
        date,
        x,
        y,
        updateTime,
        maxTemperature,
        minTemperature
    )
}

fun TempData.mapToTempEntity():TempEntity{
    return TempEntity(
        date,
        x,
        y,
        updateTime,
        maxTemperature,
        minTemperature
    )
}