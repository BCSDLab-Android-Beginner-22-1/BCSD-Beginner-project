package com.example.bcsd_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.DayForecast

class DayForecastViewModel : ViewModel() {
    private val _forecastDate = MutableLiveData<String>()
    val forecastDate: LiveData<String>
        get() = _forecastDate

    private val _forecastData = MutableLiveData<ArrayList<DayForecast>>()
    val forecastData: LiveData<ArrayList<DayForecast>>
        get() = _forecastData

    fun setForecastDate(date: String) {
        _forecastDate.value = date
    }

    fun getForecastDataByDate() {
        // Get forecast data from db
        TODO()
    }
}