package com.example.bcsd_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.*

class MainViewModel : ViewModel() {
    private val _nowLocation = MutableLiveData<LocationItem>()
    val nowLocation: LiveData<LocationItem>
        get() = _nowLocation

    private val _locationList = MutableLiveData<ArrayList<LocationItem>>()
    val locationList: LiveData<ArrayList<LocationItem>>
        get() = _locationList

    private val _todayForecastList = MutableLiveData<ArrayList<UltraShortTermForecast>>()
    val todayForecastList: LiveData<ArrayList<UltraShortTermForecast>>
        get() = _todayForecastList

    private val _nowCastData = MutableLiveData<UltraShortTermLive>()
    val nowCastData: LiveData<UltraShortTermLive>
        get() = _nowCastData

    init {
        setCurrentLocationToGPS()
        getTodayForecast()
    }

    fun changeLocation(locationItem: LocationItem) {
        _nowLocation.value = locationItem
        getNowWeather()
    }

    fun setCurrentLocationToGPS() {
        _nowLocation.value = LocationItem(null, null, null)
        getNowWeather()
    }

    private fun getNowWeather() {

    }

    private fun getTodayForecast() {

    }
}
