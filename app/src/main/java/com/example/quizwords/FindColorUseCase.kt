package com.example.quizwords

class FindColorUseCase {
    val repository: Repository = Repository()

    fun execute(inputColor : String) : Boolean =
        repository.ListaCores.any{ cor -> cor == inputColor }

}