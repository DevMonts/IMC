package br.com.imc

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val Height = findViewById<TextInputEditText>(R.id.HeightImput)
        val Weight = findViewById<TextInputEditText>(R.id.WeightImput)
        val Calculate = findViewById<AppCompatButton>(R.id.CalculateButton)
        Calculate.setOnClickListener {
            val HeightStr: String = Height.text.toString()
            val WeightStr: String = Weight.text.toString()
            if (HeightStr == ""){
                val snackbar = Snackbar.make(
                    Height,
                    "Digite a altura",
                    Snackbar.LENGTH_LONG
                )
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else if (WeightStr == "") {
                val snackbar = Snackbar.make(
                    Weight,
                    "Digite o peso",
                    Snackbar.LENGTH_LONG
                )
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else {
                val a = HeightStr.toFloat()
                val p = WeightStr.toFloat()
                val IMC = p / (a * a)
                val GoToResult = Intent(this, Result::class.java)
                GoToResult.putExtra(KEY, IMC)
                startActivity(GoToResult)
                println(IMC)
            }
        }
    }
}