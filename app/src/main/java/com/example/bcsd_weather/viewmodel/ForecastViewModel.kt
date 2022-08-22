package com.example.bcsd_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.Location
import com.example.bcsd_weather.domain.model.TempData
import com.example.bcsd_weather.domain.usecase.GetTempUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ForecastViewModel(
    private val getTempUseCase: GetTempUseCase
) : ViewModel() {
    private val _forecastData = MutableLiveData<List<TempData>>()
    val forecastData: LiveData<List<TempData>>
        get() = _forecastData

    private val _nowLocation = MutableLiveData<Location>()
    val nowLocation: LiveData<Location>
        get() = _nowLocation

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun setLocation(x: Int, y: Int) {
        _nowLocation.value = Location(x, y)
    }

    fun getForecastList() {
        _isLoading.value = true
        val date = Date()
        val todayDate = SimpleDateFormat("yyyyMMdd")

        CoroutineScope(Dispatchers.IO).launch {
            val data =
                getTempUseCase(
                    todayDate.format(date).toString(),
                    nowLocation.value!!.x,
                    nowLocation.value!!.y
                )
            _forecastData.postValue(data)
            _isLoading.postValue(false)
        }
    }
}