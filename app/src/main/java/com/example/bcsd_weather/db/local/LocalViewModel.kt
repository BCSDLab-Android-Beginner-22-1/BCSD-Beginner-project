package com.example.bcsd_weather.db.local

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.exxample.bcsd_weather.data.model.LocalEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalViewModel(application: Application):AndroidViewModel(application) {
    private val repository = LocalRepository(application)

    fun getAllLocalData(): List<LocalEntity>{
        return repository.getAllLocalData()
    }

    fun insert(localWeatherEntity: LocalEntity){
        CoroutineScope(Dispatchers.IO).launch {
            repository.insert(localWeatherEntity)
        }
    }

    fun deleteAllLocalData(){
        repository.deleteAllLocalData()
    }

}