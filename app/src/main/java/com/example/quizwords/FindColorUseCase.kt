package com.example.quizwords

class FindColorUseCase {
    val repository: Repository = Repository()

    fun execute(inputColor: String): Boolean =
        repository.colorsList.any { cor -> cor == inputColor } &&
                !repository.guessedColorsList.contains(inputColor)

    fun addGuessedColor(inputColor: String) = repository.addGuessedColor(inputColor)

}