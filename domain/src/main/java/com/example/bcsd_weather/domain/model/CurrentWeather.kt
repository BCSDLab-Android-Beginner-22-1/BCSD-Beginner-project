package com.example.bcsd_weather.domain.model

data class CurrentWeather(
    var temp: String = "",            // 온도
    var precipitation: String = "",   // 강수량
    var humidity: String = "",        // 습도
    var windSpeed: String = "",       // 풍속
    var fcstTime: String = "",        // 예보시각
)
