package com.example.bcsd_weather.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val baseUrl = "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/"

    private fun getRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun shortTermFcstService(): ShortTermForecastInterface = getRetrofit().create(
        ShortTermForecastInterface::class.java
    )

    fun ultraShortTermFcstService(): UltraShortTermForecastInterface = getRetrofit().create(
        UltraShortTermForecastInterface::class.java
    )

    fun ultraShortTermLiveService(): UltraShortTermLiveInterface = getRetrofit().create(
        UltraShortTermLiveInterface::class.java
    )
}