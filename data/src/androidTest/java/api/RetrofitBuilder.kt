package api

import com.example.bcsd_weather.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val baseUrl = BuildConfig.Weather_Api_Address

    private fun getRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun shortTermFcstService(): ShortTermForecastInterface = getRetrofit().create(api.ShortTermForecastInterface::class.java)
    fun ultraShortTermFcstService(): UltraShortTermForecastInterface = getRetrofit().create(api.UltraShortTermForecastInterface::class.java)
    fun ultraShortTermLiveService(): UltraShortTermLiveInterface = getRetrofit().create(api.UltraShortTermLiveInterface::class.java)
}