package com.example.quizwords.api

import retrofit2.http.GET
import java.util.*

interface StarWarsAPI {
    @GET("people/")
    fun getPeople() : Observable
}