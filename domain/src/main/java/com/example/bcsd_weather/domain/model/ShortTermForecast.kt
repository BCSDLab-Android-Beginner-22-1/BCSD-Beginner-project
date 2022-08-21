package com.example.bcsd_weather.domain.model

import com.example.bcsd_weather.domain.enums.ShortForecastPrecipitationType
import com.example.bcsd_weather.domain.enums.SkyType

data class ShortTermForecast(
    val forecastDate: String,
    val forecastTime: String,
    val precipitationProbability: String,
    val precipitationType: ShortForecastPrecipitationType = ShortForecastPrecipitationType.NONE,
    val precipitation: String,
    val humidity: String,
    val snow: String,
    val skyState: SkyType = SkyType.SUNNY,
    val temperature: String,
    val windDirection: String,
    val windSpeed: String,
    val waveHeight: String
)