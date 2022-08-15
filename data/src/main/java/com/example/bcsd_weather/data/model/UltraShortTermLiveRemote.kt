package com.example.bcsd_weather.data.model

import com.example.bcsd_weather.domain.enum.UltraShortLivePrecipitationType
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
    val list = response.body.items.item

    if (response.header.resultCode != 0) {
        return null
    }

    val mappedData = UltraShortTermLive()

    for (item in list) {
        when (item.category) {
            "T1H" -> {
                mappedData.temperature = item.obsrValue
            }
            "RN1" -> {
                mappedData.precipitation = item.obsrValue
            }
            "REH" -> {
                mappedData.humidity = item.obsrValue
            }
            "PTY" -> {
                mappedData.precipitationTypes = when (item.obsrValue) {
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
                mappedData.windDirection = item.obsrValue
            }
            "WSD" -> {
                mappedData.windSpeed = item.obsrValue
            }
            else -> {}
        }
    }
    return mappedData
}