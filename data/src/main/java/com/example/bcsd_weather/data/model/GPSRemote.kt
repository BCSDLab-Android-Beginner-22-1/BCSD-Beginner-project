package com.example.bcsd_weather.data.model

import com.example.bcsd_weather.data.mapper.ConvertGPS
import com.example.bcsd_weather.domain.model.Location

data class GPSRemote(val latitude: Double, val longitude: Double)

fun GPSRemote.mapToGPS(convertGPS: ConvertGPS): Location {
    return convertGPS.convertGPStoXY(latitude, longitude)
}
