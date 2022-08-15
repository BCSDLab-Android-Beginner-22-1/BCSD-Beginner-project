package com.example.bcsd_weather.domain.model

data class ShortTermTempForecast(
    var forecastDate: String? = null,
    var highestTemperature: String? = null,
    var lowestTemperature: String? = null
)
