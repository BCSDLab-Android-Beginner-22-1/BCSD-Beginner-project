package com.example.bcsd_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.model.LocalData

class DayForecastViewModel : ViewModel() {
    private val _forecastDate = MutableLiveData<String>()
    val forecastDate: LiveData<String>
        get() = _forecastDate

    private val _forecastData = MutableLiveData<List<FutureWeather>>()
    val forecastData: LiveData<List<FutureWeather>>
        get() = _forecastData

    private val _nowLocation = MutableLiveData<LocalData>()
    val nowLocation: LiveData<LocalData>
        get() = _nowLocation

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun setForecastDate(date: String) {
        _forecastDate.value = date
    }

    fun setLocation(name: String?, x: Int, y:Int) {
        _nowLocation.value = LocalData(0, name, x, y)
    }

    fun getForecastDataByDate() {
        // Get forecast data from db
        TODO()
    }
}