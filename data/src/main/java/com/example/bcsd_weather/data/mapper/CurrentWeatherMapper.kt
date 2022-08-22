package com.example.bcsd_weather.data.mapper

import com.example.bcsd_weather.data.model.CurrentWeatherEntity
import com.example.bcsd_weather.domain.model.CurrentWeather

fun CurrentWeatherEntity.mapToCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        temperature, fcstDate, fcstTime
    )
}

fun CurrentWeather.mapToCurrentWeatherEntity(x: Int, y: Int): CurrentWeatherEntity {
    return CurrentWeatherEntity(
        x,
        y,
        temperature,
        forecastDate,
        forecastTime,
        System.currentTimeMillis(),
    )
}