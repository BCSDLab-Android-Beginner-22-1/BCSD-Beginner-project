package com.example.bcsd_weather.db.local

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.bcsd_weather.domain.model.LocalData
import com.example.bcsd_weather.domain.repository.LocalRepository
import com.exxample.bcsd_weather.data.model.LocalEntity
import com.exxample.bcsd_weather.data.repository.LocalRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalViewModel(private val repository: LocalRepository) : ViewModel() {

    fun getAllLocalData(): List<LocalData> {
        return repository.getAllLocalData()
    }

    fun insertLocalData(localData: LocalData) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.insertLocalData(localData)
        }
    }

    fun deleteAllLocalData() {
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteAllLocalData()
        }

    }

}