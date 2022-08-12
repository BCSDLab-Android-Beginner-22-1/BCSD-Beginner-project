package com.example.bcsd_weather.domain.model

data class UltraShortTermLive(
    var temperature: String? = null,
    var precipitationTypes: String? = null,
    var precipitation: String? = null,
    var humidity: String? = null,
    var windDirection: String? = null,
    var windSpeed: String? = null
)
