package com.example.bcsd_weather.data.mapper

import com.example.bcsd_weather.data.CurrentWeatherEntity
import com.example.bcsd_weather.domain.model.CurrentWeather

fun CurrentWeatherEntity.mapToCurrentWeather():CurrentWeather{
    return CurrentWeather(
        temp,
        precipitation,
        humidity,
        windSpeed,
        fcstTime
    )
}

fun CurrentWeather.mapToCurrentWeatherEntity(): CurrentWeatherEntity{
    return CurrentWeatherEntity(
        temp,
        precipitation,
        humidity,
        windSpeed,
        fcstTime
    )
}