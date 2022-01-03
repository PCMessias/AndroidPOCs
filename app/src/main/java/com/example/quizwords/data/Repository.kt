package com.example.quizwords.data

import com.example.quizwords.api.StarWarsAPI
import rx.schedulers.Schedulers
import rx.android.schedulers.AndroidSchedulers

class Repository(private val service: StarWarsAPI) {
    val colorsList = listOf(
        "Azul", "Verde", "Amarelo", "Roxo", "Rosa", "Vermelho", "Branco"
    )
    val guessedColorsList = mutableListOf<String>()

    fun addGuessedColor(color : String) = guessedColorsList.add(color)

    fun getPeople() = service
        .getPeople()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    fun getSpaceships() = service
        .getSpaceships()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    fun getPlanets() = service
        .getPlanets()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}