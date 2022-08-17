package com.example.bcsd_weather

import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.usecase.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FutureWeatherViewModel(
    private val deleteWeatherUseCase: DeleteWeatherUseCase,
    private val getDetailedFutureWeatherUseCase: GetDetailedFutureWeatherUseCase,
    private val getFutureWeatherUseCase: GetFutureWeatherUseCase,
    private val insertFutureWeatherUseCase: InsertFutureWeatherUseCase,
    private val getHighestTempUseCase: GetHighestTempUseCase,
    private val getLowestTempUseCase: GetLowestTempUseCase
) : ViewModel() {

    fun insertFutureWeather(futureWeather: FutureWeather) {
        CoroutineScope(Dispatchers.IO).launch {
            insertFutureWeatherUseCase(futureWeather)
        }
    }

    fun getFutureWeather(startDate: String): List<FutureWeather> {
        return getFutureWeatherUseCase(startDate)
    }

    fun getDetailedFutureWeather(date: String): List<FutureWeather> {
        return getDetailedFutureWeatherUseCase(date)
    }

    fun deleteWeather(firstDateToKeep: String) {
        CoroutineScope(Dispatchers.IO).launch {
            deleteWeatherUseCase(firstDateToKeep)
        }
    }
    fun getHighestTemp(date: String): String {
        return getHighestTempUseCase(date).temp
    }

    fun getLowestTemp(date: String): String {
        return getLowestTempUseCase(date).temp
    }
}