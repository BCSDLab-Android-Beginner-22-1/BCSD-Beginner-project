package com.example.bcsd_weather.domain.model

data class ShortTermForecast(
    var forecastDate: String? = null,
    var forecastTime: String? = null,
    var precipitationProbability: String? = null,
    var precipitationTypes: String? = null,
    var precipitation: String? = null,
    var humidity: String? = null,
    var snow: String? = null,
    var skyState: String? = null,
    var temperature: String? = null,
    var windDirection: String? = null,
    var windSpeed: String? = null,
    var waveHeight: String? = null
)