package com.example.bcsd_weather.data.model

data class ShortTermForecastRemote(val response: StResponse)
data class StResponse(val header: StHeader, val body: StBody)
data class StHeader(val resultCode: Int, val resultMsg: String)
data class StBody(val dataType: String, val items: StItemList, val totalCount: Int)
data class StItemList(val item: List<ShortTermFcst>)

data class ShortTermFcst(
    val category: String,  // 자료 구분
    val fcstDate: String,  // 예측 날짜
    val fcstTime: String,  // 예측 시간
    val fcstValue: String  // 예보 값
)