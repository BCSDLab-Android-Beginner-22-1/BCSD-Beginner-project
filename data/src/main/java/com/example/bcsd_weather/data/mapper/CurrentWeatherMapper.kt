package com.example.bcsd_weather.data.mapper

import com.example.bcsd_weather.data.CurrentWeatherEntity
import com.example.bcsd_weather.domain.model.CurrentWeather

fun CurrentWeatherEntity.mapToCurrentWeather():CurrentWeather{
    return CurrentWeather(
        x,
        y,
        temperature,
        precipitationType,
        precipitation,
        humidity,
        windDirection,
        windSpeed,
        lastUpdateTime
    )
}

fun CurrentWeather.mapToCurrentWeatherEntity(): CurrentWeatherEntity{
    return CurrentWeatherEntity(
        x,
        y,
        temperature,
        precipitationType,
        precipitation,
        humidity,
        windDirection,
        windSpeed,
        lastUpdateTime
    )
}