package com.example.bcsd_weather.data.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.bcsd_weather.domain.enum.UltraShortLivePrecipitationType

@Entity(tableName = "current_weather", indices = [Index(value = ["fcstTime"])],primaryKeys = ["x","y","fcstTime"])
data class CurrentWeatherEntity(
    var x: Int,
    var y: Int,
    var temperature: String,
    var precipitationType: UltraShortLivePrecipitationType ,
    var precipitation: String,
    var humidity: String,
    var windDirection: String,
    var windSpeed: String,
    var fcstTime: String,
    var lastUpdateTime: Long,


)



