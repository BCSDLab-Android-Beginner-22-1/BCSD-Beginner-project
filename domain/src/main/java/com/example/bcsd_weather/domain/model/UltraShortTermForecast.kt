package com.example.bcsd_weather.domain.model

data class UltraShortTermForecast(
    var temperature: String? = null,
    var skyState: String? = null,
    var precipitationTypes: String? = null,
    var precipitation: String? = null,
    var humidity: String? = null,
    var windDirection: String? = null,
    var windSpeed: String? = null,
    var forecastTime: String? = null
)
