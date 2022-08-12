package com.example.bcsd_weather.data.api

import com.example.bcsd_weather.data.BuildConfig
import com.example.bcsd_weather.data.model.ShortTermForecastRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface ShortTermForecastInterface {
    @GET("getVilageFcst")
    suspend fun getWeather(
        @Query("serviceKey") serviceKey: String = BuildConfig.Weather_Api_Key,// 인증키
        @Query("numOfRows") numOfRows: Int = 1000,   // 한 페이지 경과 수
        @Query("pageNo") pageNo: Int = 1,          // 페이지 번호
        @Query("dataType") dataType: String = "JSON",   // 응답 자료 형식
        @Query("base_date") baseDate: String,  // 발표 일자
        @Query("base_time") baseTime: String,  // 발표 시각
        @Query("nx") nx: Int,                   // 예보지점 X 좌표
        @Query("ny") ny: Int                    // 예보지점 Y 좌표
    ): ShortTermForecastRemote
}