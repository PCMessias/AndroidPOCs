package com.example.quizwords.api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.plugins.RxJavaCompletableExecutionHook


class RetroFitConfig{
    var retrofit = Retrofit.Builder()
        .baseUrl("https://swapi.dev/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()

    var service: StarWarsAPI = retrofit.create(StarWarsAPI::class.java)
}