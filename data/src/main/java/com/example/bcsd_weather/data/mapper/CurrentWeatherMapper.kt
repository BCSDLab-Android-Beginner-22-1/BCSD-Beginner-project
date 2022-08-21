package com.example.bcsd_weather.data.mapper

import com.example.bcsd_weather.data.CurrentWeatherEntity
import com.example.bcsd_weather.domain.model.CurrentWeather

fun CurrentWeatherEntity.mapToCurrentWeather():CurrentWeather{
    return CurrentWeather(
        temperature,
        precipitationType,
        precipitation,
        humidity,
        windDirection,
        windSpeed,
        fcstTime
    )
}

fun CurrentWeather.mapToCurrentWeatherEntity(x: Int,y: Int): CurrentWeatherEntity{
    return CurrentWeatherEntity(
        x,
        y,
        temperature,
        precipitationType,
        precipitation,
        humidity,
        windDirection,
        windSpeed,
        fcstTime,
        System.currentTimeMillis(),

    )
}