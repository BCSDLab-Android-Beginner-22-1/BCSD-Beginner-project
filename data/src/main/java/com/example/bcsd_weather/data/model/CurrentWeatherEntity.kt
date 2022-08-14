package com.example.bcsd_weather.data

import androidx.room.Entity
import androidx.room.Index

@Entity(tableName = "current_weather", indices = [Index(value = ["fcstTime"])], primaryKeys = ["fcstTime"])
data class CurrentWeatherEntity(
    var temp: String = "",            // 온도
    var precipitation: String = "",   // 강수량
    var humidity: String = "",        // 습도
    var windSpeed: String = "",       // 풍속
    var fcstTime: String = "",        // 예보시각
)


