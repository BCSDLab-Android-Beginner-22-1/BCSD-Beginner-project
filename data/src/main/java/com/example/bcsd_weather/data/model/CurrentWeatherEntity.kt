package com.example.bcsd_weather.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "current_weather", indices = [Index(value = ["fcstTime"])])
data class CurrentWeatherEntity(
    @PrimaryKey
    var fcstTime: String = "",        // 예보시각
    var temp: String = "",            // 온도
    var precipitation: String = "",   // 강수량
    var humidity: String = "",        // 습도
    var windSpeed: String = ""       // 풍속
)


