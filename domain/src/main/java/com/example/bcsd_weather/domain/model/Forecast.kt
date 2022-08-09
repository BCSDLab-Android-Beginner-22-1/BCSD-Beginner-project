package com.example.bcsd_weather.domain.model

data class Forecast(
    val forecastDate: String,
    val highestTemperature: String,
    val lowestTemperature: String
)