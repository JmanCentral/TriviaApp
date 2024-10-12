package com.arquitectura.triviapp.Entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_table")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    var username: String,
    var subject: String,
    var earned: Int,
    var date: String,
    var time: String//for overall points to be calculated
)
