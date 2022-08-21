package com.example.bcsd_weather.domain.model

import com.example.bcsd_weather.domain.enums.ShortForecastPrecipitationType
import com.example.bcsd_weather.domain.enums.SkyType

data class FutureWeather(
    val forecastDate: String,
    val forecastTime: String,
    val precipitationProbability: String,
    val precipitationType: ShortForecastPrecipitationType,
    val precipitation: String,
    val humidity: String,
    val snow: String,
    val skyState: SkyType,
    val temperature: String,
    val windDirection: String,
    val windSpeed: String,
    val waveHeight: String
)