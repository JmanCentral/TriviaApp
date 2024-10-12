package com.arquitectura.triviapp.Servicios

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.arquitectura.triviapp.Entidades.HistoryDatabase
import com.arquitectura.triviapp.Entidades.HistoryEntity
import com.arquitectura.triviapp.Repositorios.HistoryRepository

class HistoryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: HistoryRepository

    init {
        val dao = HistoryDatabase.getDatabase(application).historyDao()
        repository = HistoryRepository(dao)
    }


    fun insert(historyEntity: HistoryEntity) {
        repository.insert(historyEntity)
    }

    fun getDataOfUser(user: String): LiveData<List<HistoryEntity>> {
        return repository.getDataOfUser(user)
    }

    fun getTotalPointsOfUser(user: String): Int {
        return repository.getTotalPointsOfUser(user)
    }

}