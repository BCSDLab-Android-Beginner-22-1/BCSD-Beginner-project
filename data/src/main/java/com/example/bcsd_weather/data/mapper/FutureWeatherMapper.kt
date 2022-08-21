package com.example.bcsd_weather.data.mapper

import com.example.bcsd_weather.data.model.FutureWeatherEntity
import com.example.bcsd_weather.domain.model.FutureWeather

fun FutureWeatherEntity.mapToFutureWeather(): FutureWeather {
    return FutureWeather(
        x,
        y,
        fcstDate,
        fcstTime,
        precipitationProbability,
        precipitationTypes,
        precipitation,
        humidity,
        snow,
        skyState,
        temp,
        windDirection,
        windSpeed,
        waveHeight,
        lastUpdateTime
    )
}

fun FutureWeather.mapToFutureWeatherEntity(): FutureWeatherEntity {
    return FutureWeatherEntity(
        x,
        y,
        fcstDate,
        fcstTime,
        precipitationProbability,
        precipitationTypes,
        precipitation,
        humidity,
        snow,
        skyState,
        temp,
        windDirection,
        windSpeed,
        waveHeight,
        lastUpdateTime
    )
}