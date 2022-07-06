package com.example.kotlin_calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var tvInput:TextView?=null

    var lastNumeric : Boolean = true
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tvInput)

    }


    fun onDigit (view: View) {
        tvInput?.append((view as Button).text)
        var lastNumeric = true
        var lastDot: Boolean = false


    }

    fun onCLear (view: View) {
        tvInput?.text = ""
    }
    fun onDecimalPoint (view : View) {

        if (lastNumeric && !lastDot) {


        }
    }
    fun onOperator (view:View) {
        tvInput?.text?.let {
            if (lastNumeric && !isOperatorIsAdded(it.toString())) {
                tvInput?.append((view as Button).text)
                 lastNumeric = false
                 lastDot = false
            }
        }
    }
    fun onEqual (view : View) {
        if (lastNumeric) {
            var tvValue = tvInput?.text.toString()
            var prefix = ""

            try {
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                if (tvValue.contains("-")) {

                    val splitValue = tvValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    tvInput?.text = (one.toDouble() - two.toDouble()).toString()
                }

            }catch (e : ArithmeticException ) {
                e.printStackTrace()
            }
        }
    }
    private fun isOperatorIsAdded (value : String) : Boolean {
        return if (value.startsWith("-")) {

            false
        } else {
            value.contains("/")
                    || value.contains ("*")
                    || value.contains ("+")
                    || value.contains ("-")

        }


    }
}