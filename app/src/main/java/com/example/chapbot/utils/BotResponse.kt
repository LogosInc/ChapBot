package com.example.chapbot.utils

import com.example.chapbot.utils.Constants.OPEN_GOOGLE
import com.example.chapbot.utils.Constants.OPEN_SEARCH
import java.lang.Exception

object BotResponse {

    fun basicResponse(_message: String): String{

        val random = (0..2).random()
        val message = _message.toLowerCase()

        return when{

            // Hello
            message.contains("hello") ->{
                when(random){
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "Buongiorno!"
                    else -> "error"
                }
            }

            // How are you?
            message.contains("how are you") -> {
                when(random){
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I'm hungry..."
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }

            // Flip the coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            // Solves maths
            message.contains("solve") -> {
                val equation: String = message.substringAfter("solve")

                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    answer.toString()
                }catch (e: Exception){
                    "Sorry, I cant solve that!"
                }
            }

            // Gets the current time
            message.contains("time") && message.contains("?") ->{
                Time.timeStamp()
            }

            // Open Google
            message.contains("open") && message.contains("google") ->{
                OPEN_GOOGLE
            }

            // Open Search
            message.contains("search") ->{
                OPEN_SEARCH
            }


            // When the program doesnt understand
            else -> {
                when(random){
                    0 -> "I'm dont understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "error"
                }
            }
        }
    }
}