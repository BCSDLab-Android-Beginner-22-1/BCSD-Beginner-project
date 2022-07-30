package com.example.bcsd_weather.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherObject {
    private const val baseUrl = "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofitService(): WeatherInterface = getRetrofit().create(WeatherInterface::class.java)
}