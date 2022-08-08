package com.example.bcsd_weather.db.local

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalViewModel(application: Application):AndroidViewModel(application) {
    private val repository = LocalRepository(application)

    fun getAllLocalData(): LiveData<List<LocalEntity>>{
        return repository.getAllLocalData()
    }

    fun insert(localWeatherEntity: LocalEntity){
        CoroutineScope(Dispatchers.IO).launch {
            repository.insert(localWeatherEntity)
        }
    }

    fun deletAllLocalData(){
        CoroutineScope(Dispatchers.IO).launch(
            repository.deleteAllLocalData()
        )
    }

}