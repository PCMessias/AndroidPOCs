package com.example.quizwords.api

import android.graphics.Bitmap

data class StarWarsResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)