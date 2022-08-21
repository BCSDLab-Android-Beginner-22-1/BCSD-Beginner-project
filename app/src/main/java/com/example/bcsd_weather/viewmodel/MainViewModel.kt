package com.example.bcsd_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bcsd_weather.domain.model.LocalData
import com.example.bcsd_weather.domain.model.CurrentWeather
import com.example.bcsd_weather.domain.model.UltraShortTermLive
import com.example.bcsd_weather.domain.usecase.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val initGPSLocationUseCase: InitGPSLocationUseCase,
    private val getGPSLocationUseCase: GetGPSLocationUseCase,
    private val getLocalUseCase: GetLocalUseCase,
    private val insertLocalUseCase: InsertLocalUseCase,
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getUltraSrtLiveUseCase: GetUltraSrtLiveUseCase
) : ViewModel() {
    private val _nowLocation = MutableLiveData<LocalData>()
    val nowLocation: LiveData<LocalData>
        get() = _nowLocation

    private val _locationList = MutableLiveData<List<LocalData>>()
    val locationList: LiveData<List<LocalData>>
        get() = _locationList

    private val _todayForecastList = MutableLiveData<List<CurrentWeather>>()
    val todayForecastList: LiveData<List<CurrentWeather>>
        get() = _todayForecastList

    private val _nowCastData = MutableLiveData<UltraShortTermLive?>()
    val nowCastData: LiveData<UltraShortTermLive?>
        get() = _nowCastData

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
    }

    fun changeLocation(localData: LocalData) {
        _nowLocation.value = localData
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
                                _nowLocation.value = LocalData(0, null, location.x, location.y)
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
