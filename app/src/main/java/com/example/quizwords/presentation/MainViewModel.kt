package com.example.quizwords.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizwords.data.FakePointsDao
import com.example.quizwords.domain.FindColorUseCase

class MainViewModel : ViewModel() {
    val useCase = FindColorUseCase()
    val dao = FakePointsDao()
    private val pointsMutableLiveData = MutableLiveData<Int>()
    private val guessedColorsMutableLiveData = MutableLiveData<String>()
    val pointsLiveData : LiveData<Int>
    get() = pointsMutableLiveData
    val guessedColorsLiveData : LiveData<String>
    get() = guessedColorsMutableLiveData

    private val responseMutableLiveData = MutableLiveData<List<String>>()
    val responseListLiveData : LiveData<List<String>>
        get() = responseMutableLiveData

    fun appendColors(color : String) : String = color + "\n"

//    fun findColor(color: String) {
//        val result = useCase.execute(color)
//
//        if(result) {
//            useCase.addGuessedColor(color)
//            dao.addPoint()
//            pointsMutableLiveData.postValue(dao.getPoints())
//            guessedColorsMutableLiveData.postValue(appendColors(color))
//        }
//    }

    fun fetchPeople() {
        useCase.getPeople().subscribe(
            { response ->
                responseMutableLiveData.postValue(response)

            },
            { error ->
                error.printStackTrace()
            }
        )
    }

    fun fetchSpaceships() {
        useCase.getSpaceships().subscribe(
            { response ->
                responseMutableLiveData.postValue(response)

            },
            { error ->
                error.printStackTrace()
            }
        )
    }

    fun fetchPlanets() {
        useCase.getPlanets().subscribe(
            { response ->
                responseMutableLiveData.postValue(response)

            },
            { error ->
                error.printStackTrace()
            }
        )
    }

}