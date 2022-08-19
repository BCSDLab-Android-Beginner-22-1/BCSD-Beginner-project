package com.example.bcsd_weather.domain.model

import com.example.bcsd_weather.domain.enum.UltraShortLivePrecipitationType

data class UltraShortTermLive(
    val temperature: String,
    val precipitationType: UltraShortLivePrecipitationType = UltraShortLivePrecipitationType.NONE,
    val precipitation: String,
    val humidity: String,
    val windDirection: String,
    val windSpeed: String
)