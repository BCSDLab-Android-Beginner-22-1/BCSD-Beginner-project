package com.example.bcsd_weather.domain.model

import com.example.bcsd_weather.domain.enums.ShortForecastPrecipitationType
import com.example.bcsd_weather.domain.enums.SkyType

data class FutureWeather(
    var fcstDate: String ,  // 예측 날짜
    var fcstTime: String ,   // 예보시각
    var precipitationProbability: String , // 강수 확률
    var precipitationTypes: ShortForecastPrecipitationType , // 강수 형태
    var precipitation: String ,   // 강수량
    var humidity: String ,        // 습도
    var snow: String , // 적설량
    var skyState: SkyType , // 하늘 상태
    var temp: String ,            // 온도
    var windDirection: String , // 풍향
    var windSpeed: String ,       // 풍속
    var waveHeight: String
)