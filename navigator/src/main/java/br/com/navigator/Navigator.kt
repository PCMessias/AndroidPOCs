package br.com.navigator

import android.content.Context
import android.content.Intent

interface MainNavigator {
    fun navigateMainActivity(context : Context) : Intent
}

interface ResponseNavigator {
    fun navigateResponseActivity(context : Context) : Intent
}