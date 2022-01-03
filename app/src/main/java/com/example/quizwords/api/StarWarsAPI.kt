package com.example.quizwords.api

import retrofit2.http.GET
import rx.Observable


interface StarWarsAPI {
    @GET("people/")
    fun getPeople() : Observable<StarWarsPeopleResponse>

    @GET("starships/")
    fun getSpaceships() : Observable<StarWarsSpaceshipsResponse>

    @GET("planets/")
    fun getPlanets() : Observable<StarWarsPlanetsResponse>
}