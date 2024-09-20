package com.cs407.calculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val firstInput = findViewById<EditText>(R.id.firstNumber)
        val secondInput = findViewById<EditText>(R.id.secondNumber)
        val addButton = findViewById<Button>(R.id.addButton)
        val minusButton = findViewById<Button>(R.id.minusButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)

        addButton.setOnClickListener {
            val firstNum = try {firstInput.text.toString().toInt()}
            catch (e: NumberFormatException) { 0 }
            val secondNum = try {secondInput.text.toString().toInt()}
            catch (e: NumberFormatException) { 0 }

            val result = firstNum + secondNum

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result.toString())

            startActivity(intent)
        }

        minusButton.setOnClickListener {
            val firstNum = try {firstInput.text.toString().toInt()}
            catch (e: NumberFormatException) { 0 }
            val secondNum = try {secondInput.text.toString().toInt()}
            catch (e: NumberFormatException) { 0 }

            val result = firstNum - secondNum

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result.toString())

            startActivity(intent)
        }

        multiplyButton.setOnClickListener {
            val firstNum = try {firstInput.text.toString().toInt()}
            catch (e: NumberFormatException) { 0 }
            val secondNum = try {secondInput.text.toString().toInt()}
            catch (e: NumberFormatException) { 0 }

            val result = firstNum * secondNum

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result.toString())

            startActivity(intent)
        }

        divideButton.setOnClickListener {
            val firstNum = try {firstInput.text.toString().toInt()}
            catch (e: NumberFormatException) { 0 }
            val secondNum = try {secondInput.text.toString().toInt()}
            catch (e: NumberFormatException) { 0 }

            var result = ""
            if (secondNum == 0){
                result = "Error: Dividing By Zero"
            } else {
                result = (firstNum / secondNum).toString()
            }
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result)

            startActivity(intent)
        }
    }
}