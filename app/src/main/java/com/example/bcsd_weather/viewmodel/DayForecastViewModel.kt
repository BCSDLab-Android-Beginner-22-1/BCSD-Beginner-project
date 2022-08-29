package com.example.bcsd_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.model.Location
import com.example.bcsd_weather.domain.usecase.GetDetailedFutureWeatherUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DayForecastViewModel(
    private val getDetailedFutureWeatherUseCase: GetDetailedFutureWeatherUseCase
) : ViewModel() {
    private val _forecastDate = MutableLiveData<String>()
    val forecastDate: LiveData<String>
        get() = _forecastDate

    private val _forecastData = MutableLiveData<List<FutureWeather>>()
    val forecastData: LiveData<List<FutureWeather>>
        get() = _forecastData

    private val _nowLocation = MutableLiveData<Location>()
    val nowLocation: LiveData<Location>
        get() = _nowLocation

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun setForecastDate(date: String) {
        _forecastDate.value = date
    }

    fun setLocation(x: Int, y: Int) {
        _nowLocation.value = Location(x, y)
    }

    fun getForecastDataByDate() {
        CoroutineScope(Dispatchers.IO).launch {
            _isLoading.postValue(true)
            val data = getDetailedFutureWeatherUseCase(
                forecastDate.value!!,
                nowLocation.value!!.x, nowLocation.value!!.y
            )
            _forecastData.postValue(data)
            _isLoading.postValue(false)
        }
    }
}