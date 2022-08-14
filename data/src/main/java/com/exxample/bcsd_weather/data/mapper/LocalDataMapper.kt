package com.exxample.bcsd_weather.data.mapper

import com.example.bcsd_weather.domain.model.LocalData
import com.exxample.bcsd_weather.data.model.LocalEntity

fun LocalEntity.mapToLocalData():LocalData{
    return LocalData(
        id,
        firstLocalName,
        secondLocalName,
        thirdLocalName,
        x,
        y
    )
}

fun LocalData.mapToLocalEntity():LocalEntity{
    return LocalEntity(
        id,
        firstLocalName,
        secondLocalName,
        thirdLocalName,
        x,
        y
    )
}