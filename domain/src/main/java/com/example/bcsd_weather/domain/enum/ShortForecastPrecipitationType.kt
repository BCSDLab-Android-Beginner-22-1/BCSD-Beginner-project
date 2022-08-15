package com.example.bcsd_weather.domain.enum

/**
 * 단기 예보 강수 형태
 * NONE (0): 없음
 * RAIN (1): 비
 * RAIN_SNOW (2): 비/눈
 * SNOW (3): 눈
 * SHOWER (4): 소나기
 */

enum class ShortForecastPrecipitationType {
    NONE, RAIN, RAIN_SNOW, SNOW, SHOWER
}