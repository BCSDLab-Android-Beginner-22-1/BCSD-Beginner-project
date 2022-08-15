package com.example.bcsd_weather.data.model

import androidx.room.Entity
import androidx.room.Index


@Entity(tableName = "future_weather",
    indices = [Index(value = ["fcstDate"])],
    primaryKeys = ["fcstDate", "fcstTime"])
data class FutureWeatherEntity(
    var temp: String = "",            // 온도
    var precipitation: String = "",   // 강수량
    var humidity: String = "",        // 습도
    var windSpeed: String = "",       // 풍속
    var fcstTime: String = "",   // 예보시각
    val fcstDate: String = "",  // 예측 날짜
    val fcstValue: String = "",  // 예보 값
)