package com.example.galca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val acceptButton = findViewById<Button>(R.id.acceptButton)

        acceptButton.setOnClickListener {
            val inputText = editText.text.toString()

            if (inputText.isNotEmpty()) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("inputText", inputText)
                startActivity(intent)
            } else {
                Toast.makeText(this@MainActivity, "Por favor, introduce tu nombre para continuar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

