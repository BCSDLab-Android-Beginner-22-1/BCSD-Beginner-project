package com.example.bcsd_weather.domain.model

data class UltraShortTermForecast(
    val temp: String,
    val precipitation: String,
    val humidity: String,
    val windSpeed: String,
    val fcstTime: String
)
