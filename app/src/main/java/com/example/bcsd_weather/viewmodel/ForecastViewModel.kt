package com.example.bcsd_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.Forecast

class ForecastViewModel : ViewModel() {
    private val _forecastData = MutableLiveData<ArrayList<Forecast>>()
    val forecastData: LiveData<ArrayList<Forecast>>
        get() = _forecastData

    fun getForecastList() {
        // Get forecast list from db
        TODO()
    }
}