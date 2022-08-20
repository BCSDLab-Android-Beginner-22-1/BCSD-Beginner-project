package com.example.bcsd_weather.data.mapper

import com.example.bcsd_weather.domain.model.TempData
import com.example.bcsd_weather.data.model.TempEntity

fun TempEntity.mapToTempData():TempData{
    return TempData(
        id,
        date,
        maxTemperature,
        minTemperature
    )
}

fun TempData.mapToTempEntity():TempEntity{
    return TempEntity(
        id,
        date,
        maxTemperature,
        minTemperature
    )
}