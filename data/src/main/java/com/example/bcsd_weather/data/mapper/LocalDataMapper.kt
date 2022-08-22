package com.example.bcsd_weather.data.mapper

import com.example.bcsd_weather.domain.model.LocalData
import com.example.bcsd_weather.data.model.LocalEntity

fun LocalEntity.mapToLocalData():LocalData{
    return LocalData(
        LocalName,
        x,
        y
    )
}

fun LocalData.mapToLocalEntity():LocalEntity{
    return LocalEntity(
        LocalName!!,
        x,
        y
    )
}