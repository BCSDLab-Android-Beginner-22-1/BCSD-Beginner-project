package com.example.bcsd_weather.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UltraShortTermLiveObject {
    private const val baseUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofitService(): UltraShortTermLiveInterface = getRetrofit().create(UltraShortTermLiveInterface::class.java)
}