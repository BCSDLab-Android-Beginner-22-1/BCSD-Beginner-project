package com.example.bcsd_weather.data.model

import com.example.bcsd_weather.domain.model.UltraShortTermForecast

data class UltraShortTermForeCastRemote(val response: UstResponse)
data class UstResponse(val header: UstHeader, val body: UstBody)
data class UstHeader(val resultCode: Int, val resultMsg: String)
data class UstBody(val dataType: String, val items: UstItemList, val totalCount: Int)
data class UstItemList(val item: List<UltraShortTermFcst>)

data class UltraShortTermFcst(
    val category: String,   // 자료 구분
    val fcstDate: String,   // 예측 날짜
    val fcstTime: String,   // 예측 시간
    val fcstValue: String,  // 예보 값
)

fun UltraShortTermForeCastRemote.mapToUltraShortTermForecast(): ArrayList<UltraShortTermForecast> {
    val list = response.body.items.item

    val mappedData = ArrayList<UltraShortTermForecast>()
    var newData = UltraShortTermForecast()

    var forecastTime = ""

    for (item in list) {
        if (forecastTime != item.fcstTime && newData.temperature != null) {
            if (forecastTime != "") {
                mappedData.add(newData)
            }

            newData = UltraShortTermForecast()
            forecastTime = item.fcstTime
            newData.forecastTime = forecastTime
        }

        when (item.category) {
            "T1H" -> {
                newData.temperature = item.fcstValue
            }
            else -> {}
        }
    }
    return mappedData
}