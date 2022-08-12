package com.example.bcsd_weather.data.api

import com.example.bcsd_weather.data.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val baseUrl = BuildConfig.Weather_Api_Address

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