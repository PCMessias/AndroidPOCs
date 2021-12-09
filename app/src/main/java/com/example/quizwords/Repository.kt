package com.example.quizwords

class Repository {
    val colorsList = listOf(
        "Azul", "Verde", "Amarelo", "Roxo", "Rosa", "Vermelho", "Branco"
    )
    val guessedColorsList = mutableListOf<String>()

    fun addGuessedColor(color : String) = guessedColorsList.add(color)
}