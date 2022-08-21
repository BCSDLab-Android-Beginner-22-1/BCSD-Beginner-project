package com.example.bcsd_weather.domain.enums

/**
 * 초단기 예보 / 초단기 실황 강수 형태
 * NONE (0): 없음
 * RAIN (1): 비
 * RAIN_SNOW (2): 비/눈
 * SNOW (3): 눈
 * RAINDROP (4): 빗방울
 * RAINDROP_SNOW_FLURRY (5): 빗방울눈날림
 * SNOW_FLURRY (6): 눈날림
 */

enum class UltraShortLivePrecipitationType {
    NONE, RAIN, RAIN_SNOW, SNOW, RAINDROP, RAINDROP_SNOW_FLURRY, SNOW_FLURRY
}