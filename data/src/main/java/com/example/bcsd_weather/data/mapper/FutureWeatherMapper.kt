package com.example.bcsd_weather.data.mapper

import com.example.bcsd_weather.data.model.FutureWeatherEntity
import com.example.bcsd_weather.domain.model.FutureWeather

fun FutureWeatherEntity.mapToFutureWeather(): FutureWeather {
    return FutureWeather(
        temp,
        precipitation,
        humidity,
        windSpeed,
        fcstTime,
        category,
        fcstDate,
        fcstValue
    )
}

fun FutureWeather.mapToFutureWeatherEntity(): FutureWeatherEntity {
    return FutureWeatherEntity(
        temp,
        precipitation,
        humidity,
        windSpeed,
        fcstTime,
        category,
        fcstDate,
        fcstValue
    )
}