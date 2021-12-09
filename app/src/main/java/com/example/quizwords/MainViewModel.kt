package com.example.quizwords

class MainViewModel {
    val useCase = FindColorUseCase()
    val dao = FakePointsDao()

    fun appendColors(color : String) : String = color + "\n"

    fun findColor(color: String) : String {
        val result = useCase.execute(color)

        if(result){
            useCase.addGuessedColor(color)
            dao.addPoint()
            return appendColors(color)
        }
        return ""
    }
}