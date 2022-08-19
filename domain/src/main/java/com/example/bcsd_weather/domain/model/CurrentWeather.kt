package com.example.bcsd_weather.domain.model

import com.example.bcsd_weather.domain.enum.UltraShortLivePrecipitationType

data class CurrentWeather(
    var x: Int,
    var y: Int,
    var temperature: String,
    var precipitationType: UltraShortLivePrecipitationType = UltraShortLivePrecipitationType.NONE,
    var precipitation: String,
    var humidity: String,
    var windDirection: String,
    var windSpeed: String
)
