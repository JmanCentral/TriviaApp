package com.arquitectura.triviapp.Servicios

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.arquitectura.triviapp.Entidades.LoginCredentials
import com.arquitectura.triviapp.Entidades.LoginDatabase
import com.arquitectura.triviapp.Repositorios.LoginRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: LoginRepository

    init {
        val dao = LoginDatabase.getDatabase(application).loginDao()
        repository = LoginRepository(dao)
    }

    fun insert(login: LoginCredentials) {
        repository.insert(login)
    }

    fun checkIfUserIsRegistered(
        username: String,
        password: String
    ): LiveData<List<LoginCredentials>> {
        return repository.checkIfUserIsRegistered(username, password)
    }

    fun checkUsernameExists(username: String): LiveData<List<LoginCredentials>> {
        return repository.checkUsernameExists(username)
    }

    fun update(password: String, username: String) {
        repository.update(password,username)
    }

}