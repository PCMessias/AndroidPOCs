package com.example.quizwords.data

class FakePointsDao {
    private var points = 0

    fun addPoint(){
        points += 1
    }
    fun getPoints() = points
}