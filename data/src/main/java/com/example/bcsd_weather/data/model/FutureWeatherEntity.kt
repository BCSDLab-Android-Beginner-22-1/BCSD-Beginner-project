package com.example.bcsd_weather.data.model

import androidx.room.Entity
import androidx.room.Index
import com.example.bcsd_weather.domain.enum.ShortForecastPrecipitationType
import com.example.bcsd_weather.domain.enum.SkyType


@Entity(tableName = "future_weather",
    indices = [Index(value = ["fcstDate"])],
    primaryKeys = ["fcstDate", "fcstTime","x","y"])
data class FutureWeatherEntity(
    var x: Int,
    var y: Int,
    var fcstDate: String ,  // 예측 날짜
    var fcstTime: String ,   // 예보시각
    var precipitationProbability: String, // 강수 확률
    var precipitationTypes: ShortForecastPrecipitationType , // 강수 형태
    var precipitation: String ,   // 강수량
    var humidity: String ,        // 습도
    var snow: String , // 적설량
    var skyState: SkyType , // 하늘 상태
    var temp: String ,            // 온도
    var windDirection: String , // 풍향
    var windSpeed: String ,       // 풍속
    var waveHeight: String ,
    var lastUpdateTime: Long
)