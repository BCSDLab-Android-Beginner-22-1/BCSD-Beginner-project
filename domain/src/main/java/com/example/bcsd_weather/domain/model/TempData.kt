package com.example.bcsd_weather.domain.model

data class TempData(
    val id: Long,
    val date: Int,
    val maxTemperature: Double,
    val minTemperature: Double
)
