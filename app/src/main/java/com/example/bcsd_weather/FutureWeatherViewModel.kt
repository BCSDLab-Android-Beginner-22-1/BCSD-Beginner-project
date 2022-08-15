package com.example.bcsd_weather

import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository
import com.example.bcsd_weather.domain.usecase.DeleteWeatherUseCase
import com.example.bcsd_weather.domain.usecase.GetDetailedFutureWeatherUseCase
import com.example.bcsd_weather.domain.usecase.GetFutureWeatherUseCase
import com.example.bcsd_weather.domain.usecase.InsertFutureWeatherUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FutureWeatherViewModel(
    private val deleteWeatherUseCase: DeleteWeatherUseCase,
    private val getDetailedFutureWeatherUseCase: GetDetailedFutureWeatherUseCase,
    private val getFutureWeatherUseCase: GetFutureWeatherUseCase,
    private val insertFutureWeatherUseCase: InsertFutureWeatherUseCase,
) : ViewModel() {

    fun insertFutureWeather(futureWeather: FutureWeather) {
        CoroutineScope(Dispatchers.IO).launch {
            insertFutureWeatherUseCase(futureWeather)
        }
    }

    fun getFutureWeather(startDate: String): List<FutureWeather> {
        return getFutureWeatherUseCase(startDate)
    }

    fun getDetailedFutureWeather(date: String): FutureWeather {
        return getDetailedFutureWeatherUseCase(date)
    }

    fun deleteWeather(firstDateToKeep: String) {
        CoroutineScope(Dispatchers.IO).launch {
            deleteWeatherUseCase(firstDateToKeep)
        }
    }
}