package com.example.bcsd_weather.data.model

import com.example.bcsd_weather.domain.model.GPS

data class GPSRemote(val latitude: Double, val longitude: Double)

fun GPSRemote.mapToGPS(): GPS {
    return GPS(latitude, longitude)
}
