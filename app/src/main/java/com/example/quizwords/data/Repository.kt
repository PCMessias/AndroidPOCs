package com.example.quizwords.data

import com.example.quizwords.api.StarWarsAPI

class Repository(private val service: StarWarsAPI) {
    val colorsList = listOf(
        "Azul", "Verde", "Amarelo", "Roxo", "Rosa", "Vermelho", "Branco"
    )
    val guessedColorsList = mutableListOf<String>()

    fun addGuessedColor(color : String) = guessedColorsList.add(color)

    fun getPeople() = service
        .getPeople()
}