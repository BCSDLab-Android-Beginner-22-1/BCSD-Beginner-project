package com.example.bcsd_weather.domain.model

import com.example.bcsd_weather.domain.enums.UltraShortLivePrecipitationType

data class CurrentWeather(
    var temperature: String,
    var precipitationType: UltraShortLivePrecipitationType,
    var precipitation: String,
    var humidity: String,
    var windDirection: String,
    var windSpeed: String,
    var fcstTime: String,
)
