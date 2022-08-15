package com.example.bcsd_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.ShortTermTempForecast

class ForecastViewModel : ViewModel() {
    private val _forecastData = MutableLiveData<ArrayList<ShortTermTempForecast>>()
    val forecastData: LiveData<ArrayList<ShortTermTempForecast>>
        get() = _forecastData

    fun getForecastList() {
        // Get forecast list from db
        TODO()
    }
}