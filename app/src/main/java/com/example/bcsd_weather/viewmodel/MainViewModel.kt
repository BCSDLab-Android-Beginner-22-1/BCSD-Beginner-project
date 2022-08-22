package com.example.bcsd_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bcsd_weather.domain.model.CurrentWeather
import com.example.bcsd_weather.domain.model.LocalData
import com.example.bcsd_weather.domain.model.UltraShortTermLive
import com.example.bcsd_weather.domain.usecase.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    private val _todayForecastList = MutableLiveData<List<CurrentWeather>?>()
    val todayForecastList: LiveData<List<CurrentWeather>?>
        get() = _todayForecastList

    private val _nowCastData = MutableLiveData<UltraShortTermLive?>()
    val nowCastData: LiveData<UltraShortTermLive?>
        get() = _nowCastData

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getAllLocalData()
    }

    fun changeLocation(localData: LocalData) {
        _nowLocation.value = localData
        getNowWeather()
        getTodayForecast()
    }

    fun setCurrentLocationToGPS() {
        _isLoading.value = true
        viewModelScope.launch {
            initGPSLocationUseCase()
                .collect {
                    if (it) {
                        getGPSLocationUseCase()
                            .collect { location ->
                                _nowLocation.value = LocalData(null, location.x, location.y)
                                _isLoading.value = false
                                getNowWeather()
                                getTodayForecast()
                            }
                    }
                }

        }
    }

    private fun getNowWeather() {
        CoroutineScope(Dispatchers.IO).launch {
            _todayForecastList.postValue(
                getCurrentWeatherUseCase(
                    nowLocation.value!!.x,
                    nowLocation.value!!.y
                )
            )
        }
    }

    private fun getTodayForecast() {
        viewModelScope.launch {
            _nowCastData.value = getUltraSrtLiveUseCase(
                nowLocation.value!!.x,
                nowLocation.value!!.y
            )
        }
    }

    fun getAllLocalData() {
        CoroutineScope(Dispatchers.IO).launch {
            val data = getLocalUseCase()
            withContext(Dispatchers.Main) {
                _locationList.value = data
            }
        }
    }

    fun insertLocalData(localData: LocalData) {
        CoroutineScope(Dispatchers.IO).launch {
            insertLocalUseCase(localData)
        }
    }
}
