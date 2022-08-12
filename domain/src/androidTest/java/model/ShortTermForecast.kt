package model

data class ShortTermForecast(
    val temp: String,
    val precipitation: String,
    val humidity: String,
    val windSpeed: String,
    val fcstTime: String
)