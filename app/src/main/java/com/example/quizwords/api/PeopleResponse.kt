package com.example.quizwords.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PeopleResponse (
    @SerializedName("name") val name: String?,
    )