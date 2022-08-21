package com.example.bcsd_weather.data.model

import com.example.bcsd_weather.domain.enums.UltraShortLivePrecipitationType
import com.example.bcsd_weather.domain.model.UltraShortTermLive

data class UltraShortTermLiveRemote(val response: UslResponse)
data class UslResponse(val header: UslHeader, val body: UslBody)
data class UslHeader(val resultCode: Int, val resultMsg: String)
data class UslBody(val dataType: String, val items: UslItemList, val totalCount: Int)
data class UslItemList(val item: List<UltraShortTermLiveData>)

data class UltraShortTermLiveData(
    val category: String,   // 자료 구분
    val baseDate: String,   // 발표일자
    val baseTime: String,   // 발표시각
    val obsrValue: String,  // 실황 값
)

fun UltraShortTermLiveRemote.mapToUltraShortTermLive(): UltraShortTermLive? {
    if (response.header.resultCode != 0) {
        return null
    }

    val list = response.body.items.item

    lateinit var temperature: String
    lateinit var precipitation: String
    lateinit var humidity: String
    lateinit var precipitationType: UltraShortLivePrecipitationType
    lateinit var windDirection: String
    lateinit var windSpeed: String

    for (item in list) {
        when (item.category) {
            "T1H" -> {
                temperature = item.obsrValue
            }
            "RN1" -> {
                precipitation = item.obsrValue
            }
            "REH" -> {
                humidity = item.obsrValue
            }
            "PTY" -> {
                precipitationType = when (item.obsrValue) {
                    "0" -> UltraShortLivePrecipitationType.NONE
                    "1" -> UltraShortLivePrecipitationType.RAIN
                    "2" -> UltraShortLivePrecipitationType.RAIN_SNOW
                    "3" -> UltraShortLivePrecipitationType.SNOW
                    "4" -> UltraShortLivePrecipitationType.RAINDROP
                    "5" -> UltraShortLivePrecipitationType.RAINDROP_SNOW_FLURRY
                    "6" -> UltraShortLivePrecipitationType.SNOW_FLURRY
                    else -> UltraShortLivePrecipitationType.NONE
                }
            }
            "VEC" -> {
                windDirection = item.obsrValue
            }
            "WSD" -> {
                windSpeed = item.obsrValue
            }
            else -> {}
        }
    }

    return UltraShortTermLive(
        temperature,
        precipitationType,
        precipitation,
        humidity,
        windDirection,
        windSpeed
    )
}