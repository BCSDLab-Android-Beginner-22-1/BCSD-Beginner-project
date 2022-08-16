package com.example.bcsd_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.LocationItem
import com.example.bcsd_weather.domain.model.ShortTermForecast

class DayForecastViewModel : ViewModel() {
    private val _forecastDate = MutableLiveData<String>()
    val forecastDate: LiveData<String>
        get() = _forecastDate

    private val _forecastData = MutableLiveData<ArrayList<ShortTermForecast>>()
    val forecastData: LiveData<ArrayList<ShortTermForecast>>
        get() = _forecastData

    private val _nowLocation = MutableLiveData<LocationItem>()
    val nowLocation: LiveData<LocationItem>
        get() = _nowLocation

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun setForecastDate(date: String) {
        _forecastDate.value = date
    }

    fun getForecastDataByDate() {
        // Get forecast data from db
        TODO()
    }
}