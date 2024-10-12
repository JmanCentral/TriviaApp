package com.arquitectura.triviapp.Repositorios

import com.arquitectura.triviapp.DAO.QuestionDao
import com.arquitectura.triviapp.Entidades.QuestionEntity

    class QuestionRepository(private val dao: QuestionDao) {


        fun insert(questionEntity: QuestionEntity) {
            dao.insert(questionEntity)
        }

        fun getAllQuestions(subject: String): List<QuestionEntity> {
            return dao.getAllQuestions(subject)
        }

        fun delete(){
            dao.delete()
        }



    }