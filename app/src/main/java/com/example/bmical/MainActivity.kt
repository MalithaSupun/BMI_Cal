package com.example.bmical

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightEditText = findViewById<EditText>(R.id.weight)
        val heightEditText = findViewById<EditText>(R.id.height)
        val resultTextView = findViewById<TextView>(R.id.result)
        val calculateButton = findViewById<Button>(R.id.btn)


    }
}