package com.example.bcsd_weather.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.LocationItem
import com.example.bcsd_weather.domain.model.ShortTermTempForecast

class ForecastViewModel : ViewModel() {
    private val _forecastData = MutableLiveData<List<ShortTermTempForecast>>()
    val forecastData: LiveData<List<ShortTermTempForecast>>
        get() = _forecastData

    private val _nowLocation = MutableLiveData<LocationItem>()
    val nowLocation: LiveData<LocationItem>
        get() = _nowLocation

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun setLocation(name: String?, x: Int, y:Int) {
        _nowLocation.value = LocationItem(name, x, y)
    }

    fun getForecastList() {
        // Get forecast list from db
        TODO()
    }
}