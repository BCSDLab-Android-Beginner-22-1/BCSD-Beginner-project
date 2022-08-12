package com.example.bcsd_weather.domain.model

data class UltraShortTermForecast(
    val temperature: String? = null,
    var precipitationTypes: String? = null,
    val precipitation: String? = null,
    val humidity: String? = null,
    var windDirection: String? = null,
    var windSpeed: String? = null,
    val forecastTime: String? = null
)
