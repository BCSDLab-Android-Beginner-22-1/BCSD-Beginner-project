package com.example.bcsd_weather.data.api

import com.example.bcsd_weather.BuildConfig
import com.example.bcsd_weather.data.model.UltraShortTermForeCastRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface UltraShortTermForecastInterface {
    @GET("getUltraSrtFcst")
    fun getWeather(
        @Query("serviceKey") serviceKey: String = BuildConfig.Weather_Api_Key,// 인증키
        @Query("numOfRows") numOfRows: Int,   // 한 페이지 경과 수
        @Query("pageNo") pageNo: Int,          // 페이지 번호
        @Query("dataType") dataType: String,   // 응답자료형식
        @Query("base_date") baseDate: String,  // 발표 일자
        @Query("base_time") baseTime: String,  // 발표 시각
        @Query("nx") nx: Int,                   // 예보지점 X좌표
        @Query("ny") ny: Int                    // 예보지점 Y좌표
    ): UltraShortTermForeCastRemote
}