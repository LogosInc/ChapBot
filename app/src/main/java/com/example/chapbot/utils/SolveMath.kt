package com.example.chapbot.utils

import android.util.Log

object SolveMath {

    fun solveMath(equation: String): Int{

        val newEquation = equation.replace(" ", "")
        Log.d("Math", newEquation)

        return when{
            newEquation.contentEquals("+") -> {
                val split = newEquation.split("+")
                val result = split[0].toInt() + split[1].toInt()
                result
            }
            newEquation.contentEquals("-") -> {
                val split = newEquation.split("+")
                val result = split[0].toInt() - split[1].toInt()
                result
            }
            newEquation.contentEquals("*") -> {
                val split = newEquation.split("+")
                val result = split[0].toInt() * split[1].toInt()
                result
            }
            newEquation.contentEquals("/") -> {
                val split = newEquation.split("+")
                val result = split[0].toInt() / split[1].toInt()
                result
            }
            else -> {
                0
            }
        }
    }
}