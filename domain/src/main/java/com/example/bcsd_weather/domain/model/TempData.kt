package com.example.bcsd_weather.domain.model

data class TempData(
    val date: String,
    var updateTime : Long,
    val maxTemperature: String,
    val minTemperature: String
)
