package com.example.bcsd_weather.data.mapper

import com.example.bcsd_weather.data.model.FutureWeatherEntity
import com.example.bcsd_weather.domain.model.FutureWeather

fun FutureWeatherEntity.mapToFutureWeather(): FutureWeather {
    return FutureWeather(
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
    )
}

fun FutureWeather.mapToFutureWeatherEntity(x: Int, y: Int): FutureWeatherEntity {
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
        System.currentTimeMillis()
    )
}