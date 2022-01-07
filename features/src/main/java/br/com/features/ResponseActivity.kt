package br.com.features

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.navigator.DependecyInjector
import br.com.navigator.ResponseNavigator

class ResponseActivity : AppCompatActivity(), ResponseNavigator {
    lateinit var backButton : Button
    lateinit var responseText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_response)
        DependecyInjector.responseNavigator = this
        val mainIntent = DependecyInjector.mainNavigator?.navigateMainActivity(this)

        responseText = findViewById(R.id.tv_response)
        backButton = findViewById(R.id.bt_back)
        val response = intent.getStringExtra("responseText")

        responseText.text = response.toString()

        backButton.setOnClickListener{
            startActivity(mainIntent)
        }
    }

    override fun navigateResponseActivity(context: Context): Intent {
        return Intent(context, ResponseActivity::class.java)
    }
}