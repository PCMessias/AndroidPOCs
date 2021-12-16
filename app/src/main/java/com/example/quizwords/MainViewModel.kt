package com.example.quizwords

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val useCase = FindColorUseCase()
    val dao = FakePointsDao()
    private val points = MutableLiveData<Int>()

    fun appendColors(color : String) : String = color + "\n"

    fun findColor(color: String) : String {
        val result = useCase.execute(color)

        if(result){
            useCase.addGuessedColor(color)
            dao.addPoint()
            points.postValue(dao.getPoints())
            return appendColors(color)
        }
        return ""
    }

    fun getPoints(): LiveData<Int>{
        return points
    }
}