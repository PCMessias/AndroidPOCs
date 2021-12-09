package com.example.quizwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val viewModel = MainViewModel()

    lateinit var sendButton: Button
    lateinit var inputColor: EditText
    lateinit var guessedColors: TextView
    lateinit var guesses : TextView

    var inputText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }

    fun initializeUi() {
        sendButton = findViewById(R.id.bt_send)
        inputColor = findViewById(R.id.et_inputColor)
        guessedColors = findViewById(R.id.tv_guessedColors)
        guesses = findViewById(R.id.tv_guesses)
        sendButton.setOnClickListener {
            inputText = inputColor.text.toString()
            guessedColors.text = guessedColors.text.toString() + viewModel.findColor(inputText)
            guesses.text = viewModel.dao.getPoints().toString()
            inputColor.setText("")
        }

    }
}