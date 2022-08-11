package model

import com.google.gson.annotations.SerializedName

// 단기 예보
data class ShortTermForecastModel(
    @SerializedName("TMP") var temp: String = "",            // 온도
    @SerializedName("PCP") var precipitation: String = "",   // 강수량
    @SerializedName("PEH") var humidity: String = "",        // 습도
    @SerializedName("WSP") var windSpeed: String = "",       // 풍속
    @SerializedName("fcstTime") var fcstTime: String = "",   // 예보시각
)

// xml 파일 형식을 data class로 구현
data class StWeather(val response: StResponse)
data class StResponse(val header: StHeader, val body: StBody)
data class StHeader(val resultCode: Int, val resultMsg: String)
data class StBody(val dataType: String, val items: StItemList, val totalCount: Int)
data class StItemList(val item: List<StItem>)

data class StItem(
    val category: String,  // 자료 구분
    val fcstDate: String,  // 예측 날짜
    val fcstTime: String,  // 예측 시간
    val fcstValue: String  // 예보 값
)