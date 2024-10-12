package com.arquitectura.triviapp.Entidades

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "question_table")
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val question: String,
    val op1: String,
    val op2: String,
    val op3: String,
    val op4: String,
    val answer: String,
    val subject: String
)



