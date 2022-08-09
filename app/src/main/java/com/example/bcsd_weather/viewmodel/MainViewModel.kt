package com.example.bcsd_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.LocationItem
import com.example.bcsd_weather.domain.model.NowCast
import com.example.bcsd_weather.domain.model.TodayForecast

class MainViewModel : ViewModel() {
    private val _nowLocation = MutableLiveData<LocationItem>()
    val nowLocation: LiveData<LocationItem>
        get() = _nowLocation

    private val _locationList = MutableLiveData<ArrayList<LocationItem>>()
    val locationList: LiveData<ArrayList<LocationItem>>
        get() = _locationList

    private val _todayForecastList = MutableLiveData<ArrayList<TodayForecast>>()
    val todayForecastList: LiveData<ArrayList<TodayForecast>>
        get() = _todayForecastList

    private val _nowCastData = MutableLiveData<NowCast>()
    val nowCastData: LiveData<NowCast>
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
