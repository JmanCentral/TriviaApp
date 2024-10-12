package com.arquitectura.triviapp.Servicios

import android.app.Application
import android.telecom.Call
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arquitectura.RetrofitInstance
import com.arquitectura.TriviaQuestion
import com.arquitectura.TriviaResponse
import com.arquitectura.triviapp.Entidades.QuestionDatabase
import com.arquitectura.triviapp.Entidades.QuestionEntity
import com.arquitectura.triviapp.Repositorios.QuestionRepository
import okhttp3.Callback
import okhttp3.Response

class QuestionViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: QuestionRepository

    private val _questions = MutableLiveData<List<TriviaQuestion>>()
    val questions: LiveData<List<TriviaQuestion>> get() = _questions

    init {
        val dao = QuestionDatabase.getDatabase(application).questionDao()
        repository = QuestionRepository(dao)
    }

    fun insert(questionEntity: QuestionEntity) {
        repository.insert(questionEntity)
    }

    fun getAllQuestions(subject: String): List<QuestionEntity> {
        return repository.getAllQuestions(subject)
    }

    fun delete() {
        repository.delete()
    }

/*
    fun fetchMathQuestions() {
        RetrofitInstance.api.getMathQuestions().enqueue(object : Callback<TriviaResponse> {
            override fun onResponse(call: Call<TriviaResponse>, response: Response<TriviaResponse>) {
                if (response.isSuccessful && response.body()?.response_code == 0) {
                    _questions.postValue(response.body()?.results)
                } else {
                    // Manejar error de API
                }
            }

            override fun onFailure(call: Call<TriviaResponse>, t: Throwable) {
                // Manejar fallo de red
            }
        })
    }

    fun fetchGeographyQuestions() {
        RetrofitInstance.api.getGeographyQuestions().enqueue(object : Callback<TriviaResponse> {
            override fun onResponse(call: Call<TriviaResponse>, response: Response<TriviaResponse>) {
                if (response.isSuccessful && response.body()?.response_code == 0) {
                    _questions.postValue(response.body()?.results)
                } else {
                    // Manejar error de API
                }
            }

            override fun onFailure(call: Call<TriviaResponse>, t: Throwable) {
                // Manejar fallo de red
            }
        })
    }

    fun fetchLiteratureQuestions() {
        RetrofitInstance.api.getLiteratureQuestions().enqueue(object : Callback<TriviaResponse> {
            override fun onResponse(call: Call<TriviaResponse>, response: Response<TriviaResponse>) {
                if (response.isSuccessful && response.body()?.response_code == 0) {
                    _questions.postValue(response.body()?.results)
                } else {
                    // Manejar error de API
                }
            }

            override fun onFailure(call: Call<TriviaResponse>, t: Throwable) {
                // Manejar fallo de red
            }
        })
    }

    fun fetchHistoryQuestions() {
        RetrofitInstance.api.getHistoryQuestions().enqueue(object : Callback<TriviaResponse> {
            override fun onResponse(call: Call<TriviaResponse>, response: Response<TriviaResponse>) {
                if (response.isSuccessful && response.body()?.response_code == 0) {
                    _questions.postValue(response.body()?.results)
                } else {
                    // Manejar error de API
                }
            }

            override fun onFailure(call: Call<TriviaResponse>, t: Throwable) {
                // Manejar fallo de red
            }
        })
    }

*/
}