package com.example.bcsd_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.LocalData
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

    private val _nowLocation = MutableLiveData<LocalData>()
    val nowLocation: LiveData<LocalData>
        get() = _nowLocation

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun setLocation(name: String?, x: Int, y: Int) {
        _nowLocation.value = LocalData(0, name, x, y)
    }

    fun getForecastList() {
        // Get forecast list from db
        TODO()
    }
}