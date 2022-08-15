package com.example.bcsd_weather.domain.model

import com.example.bcsd_weather.domain.enum.ShortForecastPrecipitationType
import com.example.bcsd_weather.domain.enum.SkyType

data class ShortTermForecast(
    var forecastDate: String? = null,
    var forecastTime: String? = null,
    var precipitationProbability: String? = null,
    var precipitationTypes: ShortForecastPrecipitationType = ShortForecastPrecipitationType.NONE,
    var precipitation: String? = null,
    var humidity: String? = null,
    var snow: String? = null,
    var skyState: SkyType = SkyType.SUNNY,
    var temperature: String? = null,
    var windDirection: String? = null,
    var windSpeed: String? = null,
    var waveHeight: String? = null
)