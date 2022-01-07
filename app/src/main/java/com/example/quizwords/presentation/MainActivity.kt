package com.example.quizwords.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.com.features.ResponseActivity
import br.com.navigator.DependecyInjector
import br.com.navigator.MainNavigator
import com.example.quizwords.R

class MainActivity : AppCompatActivity(), MainNavigator {
    private val viewModel = MainViewModel()

    lateinit var sendPeopleButton: Button
    lateinit var sendSpaceshipsButton: Button
    lateinit var sendPlanetsButton: Button
    lateinit var inputColor: EditText
    lateinit var guessedColors: TextView
    lateinit var guesses: TextView

    var inputText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DependecyInjector.mainNavigator = this
        initializeUi()
        setupObserver()
    }

    override fun navigateMainActivity(context : Context): Intent = Intent(context, MainActivity::class.java)

    private fun initializeUi() {
        sendPeopleButton = findViewById(R.id.bt_sendPeople)
        sendSpaceshipsButton = findViewById(R.id.bt_sendSpaceships)
        sendPlanetsButton = findViewById(R.id.bt_sendPlanets)
        inputColor = findViewById(R.id.et_inputColor)
        guessedColors = findViewById(R.id.tv_guessedColors)
        guesses = findViewById(R.id.tv_guesses)
        sendPeopleButton.setOnClickListener {
            inputText = inputColor.text.toString()
            guessedColors.setText("")
            viewModel.fetchPeople()
            inputColor.setText("")
        }
        sendSpaceshipsButton.setOnClickListener {
            inputText = inputColor.text.toString()
            guessedColors.setText("")
            viewModel.fetchSpaceships()
            inputColor.setText("")
        }
        sendPlanetsButton.setOnClickListener {
            inputText = inputColor.text.toString()
            guessedColors.setText("")
            viewModel.fetchPlanets()
            inputColor.setText("")
        }
    }

    private fun setupObserver() {
        viewModel.pointsLiveData.observe(this) { newPoints ->
            guesses.text = newPoints.toString()
        }
        viewModel.guessedColorsLiveData.observe(this) { newGuessedColors ->
            guessedColors.text = guessedColors.text.toString() + newGuessedColors
        }
        viewModel.responseListLiveData.observe(this) { responseList ->
            responseList.forEach { item ->
                guessedColors.text = guessedColors.text.toString() + item + '\n'
            }
            sendResponseData(guessedColors.text.toString())
        }
    }

    private fun sendResponseData(response : String){
        val send = Intent(this@MainActivity, ResponseActivity::class.java)
        val b = Bundle()
        b.putSerializable("responseText", response)
        send.putExtras(b)
        startActivity(send)
    }
}