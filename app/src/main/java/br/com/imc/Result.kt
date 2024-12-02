package br.com.imc

import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY = "IMC"

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val Result = intent.getFloatExtra(KEY, 0f)
        val ResultShow = findViewById<TextView>(R.id.Result)
        val BodyShow = findViewById<TextView>(R.id.Body)
        ResultShow.text = Result.toString()
        val Body: String = if (Result <= 18.5f) {
            "Sobpeso"
        } else if (Result > 18.5f && Result <= 24.9f) {
            "Normal"
        } else if (Result > 25f && Result <= 29.9f) {
            "Sobrepeso"
        } else if (Result > 30f && Result <= 34.9f) {
            "Obesidade I"
        } else if (Result > 35f && Result <= 39.9f) {
            "Obesidade II"
        } else {
            "Obesidade III"
        }
        BodyShow.text = Body
    }
}