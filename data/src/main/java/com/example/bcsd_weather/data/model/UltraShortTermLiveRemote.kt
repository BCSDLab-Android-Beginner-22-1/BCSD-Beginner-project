package com.example.bcsd_weather.data.model

data class UltraShortTermLiveRemote(val response: UslResponse)
data class UslResponse(val header: UslHeader, val body: UslBody)
data class UslHeader(val resultCode: Int, val resultMsg: String)
data class UslBody(val dataType: String, val items: UslItemList, val totalCount: Int)
data class UslItemList(val item: List<UltraShortTermLive>)

data class UltraShortTermLive(
    val category: String,   // 자료 구분
    val baseDate: String,   // 발표일자
    val baseTime: String,   // 발표시각
    val obsrValue: String,  // 실황 값
)