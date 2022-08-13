package com.example.bcsd_weather.domain.model

data class FutureWeather(
    var temp: String = "",            // 온도
    var precipitation: String = "",   // 강수량
    var humidity: String = "",        // 습도
    var windSpeed: String = "",       // 풍속
    var fcstTime: String = "",   // 예보시각
    val category: String="",  // 자료 구분
    val fcstDate: String = "",  // 예측 날짜
    val fcstValue: String = ""  // 예보 값
)