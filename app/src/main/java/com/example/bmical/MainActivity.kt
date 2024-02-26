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

        calculateButton.setOnClickListener {
            // Close the keyboard
            hideKeyboard()

            val weightStr = weightEditText.text.toString()
            val heightStr = heightEditText.text.toString()

            if (weightStr.isNotEmpty() && heightStr.isNotEmpty()) {
                val weight = weightStr.toFloat()
                val height = heightStr.toFloat() / 100 // Convert height from cm to meters
                val bmi = calculateBMI(weight, height)
                val bmiCategory = getBMICategory(bmi)
                resultTextView.text = "Your BMI: $bmi\nCategory: $bmiCategory"
            } else {
                resultTextView.text = "Please enter both weight and height"
            }
        }
    }

    private fun calculateBMI(weight: Float, height: Float): Float {
        return weight / (height * height)
    }

    private fun getBMICategory(bmi: Float): String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi < 24.9 -> "Normal weight"
            bmi < 29.9 -> "Overweight"
            else -> "Obesity"
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

    }
}