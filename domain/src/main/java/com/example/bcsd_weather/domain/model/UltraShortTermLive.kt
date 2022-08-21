package com.example.bcsd_weather.domain.model

import com.example.bcsd_weather.domain.enum.UltraShortLivePrecipitationType

data class UltraShortTermLive(
    var temperature: String? = null,
    var precipitationTypes: UltraShortLivePrecipitationType = UltraShortLivePrecipitationType.NONE,
    var precipitation: String? = null,
    var humidity: String? = null,
    var windDirection: String? = null,
    var windSpeed: String? = null
)
