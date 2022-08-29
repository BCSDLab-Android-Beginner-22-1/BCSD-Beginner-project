package com.example.bcsd_weather.data.model

import com.example.bcsd_weather.domain.model.CurrentWeather

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

fun UltraShortTermForeCastRemote.mapToUltraShortTermForecast(): List<CurrentWeather> {

    if (response.header.resultCode != 0) {
        return listOf()
    }

    val list = response.body.items.item

    val mappedData = ArrayList<CurrentWeather>()

    for (item in list) {
        when (item.category) {
            "T1H" -> {
                mappedData.add(CurrentWeather(item.fcstValue, item.fcstDate, item.fcstTime))
            }
            else -> {}
        }
    }
    return mappedData
}