package com.example.lesson3

class Calculator {

    companion object {

        var firstOperand: Double? = null
        var secondOperand: Double? = null
        var operation: String = ""

        fun calculate(): String{
            var result: Double? = null
            if (firstOperand != null && secondOperand != null) {
                when (operation) {
                    "+" -> result = firstOperand!! + secondOperand!!
                    "-" -> result = firstOperand!! - secondOperand!!
                    "*" -> result = firstOperand!! * secondOperand!!
                    "/" -> result = firstOperand!! / secondOperand!!
                    else-> return "Неверно введена операция!"
                }
            }
            else
                return "Неверно введены операнды!"
            return result.toString()
        }
    }
}