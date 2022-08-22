package com.example.bcsd_weather.data.model

import androidx.room.Entity
import androidx.room.Index
import com.example.bcsd_weather.domain.enums.UltraShortLivePrecipitationType

@Entity(
    tableName = "current_weather",
    indices = [Index(value = ["fcstTime"])],
    primaryKeys = ["x", "y", "fcstTime"]
)
data class CurrentWeatherEntity(
    var x: Int,
    var y: Int,
    var temperature: String,
    var fcstDate: String,
    var fcstTime: String,
    var lastUpdateTime: Long
)



