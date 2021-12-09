package com.example.quizwords

class FakePointsDao {
    private var points = 0

    fun addPoint(){
        points += 1
    }
    fun getPoints() = points
}