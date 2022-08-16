package com.example.bcsd_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.LocationItem
import com.example.bcsd_weather.domain.model.ShortTermTempForecast

class ForecastViewModel : ViewModel() {
    private val _forecastData = MutableLiveData<ArrayList<ShortTermTempForecast>>()
    val forecastData: LiveData<ArrayList<ShortTermTempForecast>>
        get() = _forecastData

    private val _nowLocation = MutableLiveData<LocationItem>()
    val nowLocation: LiveData<LocationItem>
        get() = _nowLocation

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getForecastList() {
        // Get forecast list from db
        TODO()
    }
}