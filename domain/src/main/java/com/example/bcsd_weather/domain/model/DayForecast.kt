package com.example.bcsd_weather.domain.model

data class DayForecast(
    val forecastDate: String,
    val forecastTime: String,
    val precipitationProbability: String,
    val precipitationTypes: String,
    val precipitation: String,
    val humidity: String,
    val snow: String,
    val skyState: String,
    val temperature: String,
    val windDirection: String,
    val windSpeed: String,
    val waveHeight: String
)