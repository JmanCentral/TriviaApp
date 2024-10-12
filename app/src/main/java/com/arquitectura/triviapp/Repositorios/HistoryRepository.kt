package com.arquitectura.triviapp.Repositorios

import androidx.lifecycle.LiveData
import com.arquitectura.triviapp.DAO.HistoryDao
import com.arquitectura.triviapp.Entidades.HistoryEntity

class HistoryRepository(private val dao: HistoryDao) {


    fun insert(historyEntity: HistoryEntity) {
        dao.insert(historyEntity)
    }

    fun getDataOfUser(user: String): LiveData<List<HistoryEntity>> {
        return dao.getDataOfUser(user)
    }

    fun getTotalPointsOfUser(user: String): Int{
        return dao.getTotalPointsOfUser(user)
    }

}