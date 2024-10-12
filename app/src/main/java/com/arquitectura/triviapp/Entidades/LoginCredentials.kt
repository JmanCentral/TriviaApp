package com.arquitectura.triviapp.Entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login_table")
data class LoginCredentials(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    var username: String,
    var password: String,
    var email: String
)