package com.example.bcsd_weather.network

import com.example.bcsd_weather.BuildConfig
import com.example.bcsd_weather.data.UslWEATHER
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UltraShortTermLiveInterface {
    @GET("getUltraSrtNcst")
    fun getWeather(
        @Query("serviceKey") serviceKey: String = BuildConfig.Weather_Api_Key, // 인증키
        @Query("numOfRows") numOfRows: Int,   // 한 페이지 경과 수
        @Query("pageNo") page_no: Int,          // 페이지 번호
        @Query("dataType") data_type: String,   // 응답 자료 형식
        @Query("base_date") base_date: String,  // 발표 일자
        @Query("base_time") base_time: String,  // 발표 시각
        @Query("nx") nx: Int,                   // 예보지점 X 좌표
        @Query("ny") ny: Int                    // 예보지점 Y 좌표
    ): Call<UslWEATHER>
}