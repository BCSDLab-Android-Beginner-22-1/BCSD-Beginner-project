package com.example.bcsd_weather.network

import com.example.bcsd_weather.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherObject {
    private const val baseUrl = BuildConfig.Weather_Api_Address

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun shortTermFcstService(): ShortTermForecastInterface = getRetrofit().create(ShortTermForecastInterface::class.java)
    fun ultraShortTermFcstService(): UltraShortTermLiveInterface = getRetrofit().create(UltraShortTermLiveInterface::class.java)
    fun ultraShortTermLiveService(): UltraShortTermLiveInterface = getRetrofit().create(UltraShortTermLiveInterface::class.java)
}