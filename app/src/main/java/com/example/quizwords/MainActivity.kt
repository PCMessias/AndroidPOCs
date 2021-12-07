package com.example.quizwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val viewModel = MainViewModel()

    lateinit var button : Button
    lateinit var editText : EditText
    lateinit var textView : TextView

    var inputText : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }

    fun initializeUi(){
        button = findViewById(R.id.button)
        editText  = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
         button.setOnClickListener {
             inputText = editText.text.toString()
             textView.text = textView.text.toString() + viewModel.findColor(inputText)
             editText.setText("")
         }

    }
}