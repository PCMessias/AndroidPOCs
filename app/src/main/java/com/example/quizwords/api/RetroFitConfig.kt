package com.example.quizwords.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetroFitConfig{
    var retrofit = Retrofit.Builder()
        .baseUrl("https://swapi.dev/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: StarWarsAPI = retrofit.create(StarWarsAPI::class.java)
}