package com.example.bcsd_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bcsd_weather.domain.model.LocationItem
import com.example.bcsd_weather.domain.model.UltraShortTermForecast
import com.example.bcsd_weather.domain.model.UltraShortTermLive
import com.example.bcsd_weather.domain.usecase.GetGPSLocationUseCase
import com.example.bcsd_weather.domain.usecase.InitGPSLocationUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val initGPSLocationUseCase: InitGPSLocationUseCase,
    private val getGPSLocationUseCase: GetGPSLocationUseCase
) : ViewModel() {
    private val _nowLocation = MutableLiveData<LocationItem>()
    val nowLocation: LiveData<LocationItem>
        get() = _nowLocation

    private val _locationList = MutableLiveData<List<LocationItem>>()
    val locationList: LiveData<List<LocationItem>>
        get() = _locationList

    private val _todayForecastList = MutableLiveData<List<UltraShortTermForecast>>()
    val todayForecastList: LiveData<List<UltraShortTermForecast>>
        get() = _todayForecastList

    private val _nowCastData = MutableLiveData<UltraShortTermLive>()
    val nowCastData: LiveData<UltraShortTermLive>
        get() = _nowCastData

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
    }

    fun changeLocation(locationItem: LocationItem) {
        _nowLocation.value = locationItem
        getNowWeather()
    }

    fun setCurrentLocationToGPS() {
        _isLoading.value = true
        viewModelScope.launch {
            initGPSLocationUseCase()
                .collect {
                    if (it) {
                        getGPSLocationUseCase()
                            .collect { location ->
                                _nowLocation.value = LocationItem(null, location.x, location.y)
                                _isLoading.value = false
                                getNowWeather()
                                getTodayForecast()
                            }
                    }
                }

        }
    }

    private fun getNowWeather() {

    }

    private fun getTodayForecast() {

    }
}
