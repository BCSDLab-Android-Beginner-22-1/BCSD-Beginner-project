package com.example.bcsd_weather


import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.CurrentWeather
import com.example.bcsd_weather.domain.usecase.DeleteCurrentWeatherUseCase
import com.example.bcsd_weather.domain.usecase.GetCurrentWeatherUseCase
import com.example.bcsd_weather.domain.usecase.InsertCurrentWeatherUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CurrentWeatherViewModel(
    private val deleteCurrentWeatherUseCase: DeleteCurrentWeatherUseCase,
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val insertCurrentWeatherUseCase: InsertCurrentWeatherUseCase,
) : ViewModel() {

    fun insertCurrentWeather(weather: CurrentWeather) {
        CoroutineScope(Dispatchers.IO).launch {
            insertCurrentWeatherUseCase(weather)
        }
    }

    fun deleteCurrentWeather(weather: CurrentWeather) {
        CoroutineScope(Dispatchers.IO).launch {
            deleteCurrentWeatherUseCase(weather)
        }
    }


    fun getCurrentWeather(): List<CurrentWeather> {
        return getCurrentWeatherUseCase()
    }


}