package com.example.quizwords

class MainViewModel {
    val useCase = FindColorUseCase()

    fun appendColors(color : String) : String = color + "\n"

    fun findColor(color: String) : String {
        val result = useCase.execute(color)

        if(result){
            return appendColors(color)
        }
        return ""
    }
}