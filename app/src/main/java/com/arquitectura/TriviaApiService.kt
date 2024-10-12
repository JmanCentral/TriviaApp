package com.arquitectura

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaApiService {
    @GET("api.php")
    fun getMathQuestions(
        @Query("amount") amount: Int = 10,
        @Query("category") category: Int = 19, // ID de categoría para Matemáticas
        @Query("difficulty") difficulty: String = "easy",
        @Query("type") type: String = "multiple"
    ): Call<TriviaResponse>

    @GET("api.php")
    fun getGeographyQuestions(
        @Query("amount") amount: Int = 10,
        @Query("category") category: Int = 22, // ID de categoría para Geografía
        @Query("difficulty") difficulty: String = "easy",
        @Query("type") type: String = "multiple"
    ): Call<TriviaResponse>

    @GET("api.php")
    fun getLiteratureQuestions(
        @Query("amount") amount: Int = 10,
        @Query("category") category: Int = 21, // ID de categoría para Literatura
        @Query("difficulty") difficulty: String = "easy",
        @Query("type") type: String = "multiple"
    ): Call<TriviaResponse>

    @GET("api.php")
    fun getHistoryQuestions(
        @Query("amount") amount: Int = 10,
        @Query("category") category: Int = 23, // ID de categoría para Historia
        @Query("difficulty") difficulty: String = "easy",
        @Query("type") type: String = "multiple"
    ): Call<TriviaResponse>
}

