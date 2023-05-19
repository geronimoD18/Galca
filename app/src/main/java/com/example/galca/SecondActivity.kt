package com.example.galca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class SecondActivity : AppCompatActivity() {
    private lateinit var textViewNumbers: TextView
    private val exchangeRateDOPtoUSD = 0.018
    private val exchangeRateUSDtoDOP = 54.85
    private val exchangeRateDOPtoEUR = 0.017
    private val exchangeRateEURtoDOP = 59.04
    private val decimalFormat = DecimalFormat("#,###.##")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // para poder imprimir el nombre ingresado
        val inputText = intent.getStringExtra("inputText")
        val textView2 = findViewById<TextView>(R.id.textView2)
        textView2.text = "Bienvenido, $inputText"

        // para poder ver los cálculos
        textViewNumbers = findViewById(R.id.textViewNumbers)
    }

    fun onButtonClicked(view: View) {
        val button = view as Button
        val buttonText = button.text.toString()
        val currentText = textViewNumbers.text.toString()

        if (buttonText == "C") {
            textViewNumbers.text = ""
        } else if (buttonText == ".") {
            textViewNumbers.text = currentText + buttonText
        } else {
            when (buttonText) {
                "DOP - USD" -> {
                    val dopAmount = currentText.toDoubleOrNull()
                    if (dopAmount != null) {
                        val usdAmount = dopAmount * exchangeRateDOPtoUSD
                        val formattedAmount = decimalFormat.format(usdAmount)
                        textViewNumbers.text = "$currentText DOP = $formattedAmount USD"
                    }
                }
                "USD - DOP" -> {
                    val usdAmount = currentText.toDoubleOrNull()
                    if (usdAmount != null) {
                        val dopAmount = usdAmount * exchangeRateUSDtoDOP
                        val formattedAmount = decimalFormat.format(dopAmount)
                        textViewNumbers.text = "$currentText USD = $formattedAmount DOP"
                    }
                }
                "DOP - EURO" -> {
                    val dopAmount = currentText.toDoubleOrNull()
                    if (dopAmount != null) {
                        val euroAmount = dopAmount * exchangeRateDOPtoEUR
                        val formattedAmount = decimalFormat.format(euroAmount)
                        textViewNumbers.text = "$currentText DOP = $formattedAmount EURO"
                    }
                }
                "EURO - DOP" -> {
                    val euroAmount = currentText.toDoubleOrNull()
                    if (euroAmount != null) {
                        val dopAmount = euroAmount * exchangeRateEURtoDOP
                        val formattedAmount = decimalFormat.format(dopAmount)
                        textViewNumbers.text = "$currentText EURO = $formattedAmount DOP"
                    }
                }
                else -> {
                    textViewNumbers.text = currentText + buttonText
                }
            }
        }
    }
}
