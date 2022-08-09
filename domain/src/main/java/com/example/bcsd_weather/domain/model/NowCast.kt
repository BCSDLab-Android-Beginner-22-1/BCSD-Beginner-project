package com.example.bcsd_weather.domain.model

data class NowCast(
    val temperature: String,
    val precipitationTypes: String,
    val precipitation: String,
    val humidity: String,
    val windDirection: String,
    val windSpeed: String
)