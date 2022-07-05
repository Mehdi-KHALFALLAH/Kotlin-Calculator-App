package com.example.kotlin_calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var tvInput:TextView?=null
    var lastNumeric: Boolean = false
    var lastDot: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tvInput)
    }


    fun onDigit (view: View) {
        tvInput?.append((view as Button).text)
    }

    fun onCLear (view: View) {
        tvInput?.text = ""
    }
}