package com.example.studyingmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StandardCalcViewModel : ViewModel() {

    var lastDigit: String = ""
    var result = MutableLiveData<String>("0")
    var opCount: Int = 0
    var resultRemember: Double = 0.0

    var prevOperator: String = ""
    var currentOperator: String = ""

    var prevLogicResult: String = ""
    var lastLogicResult: String = ""

    var lastStringIsDigitOrOp: Boolean = true
    var lastStringIsLogicResultOrNot = false


    /**
     * Numbers
     */

    fun btnNumberOne() {
        appendOnResultView("1", true)
    }

    fun btnNumberTwo() {
        appendOnResultView("2", true)
    }

    fun btnNumberThree() {
        appendOnResultView("3", true)
    }

    fun btnNumberFour() {
        appendOnResultView("4", true)
    }

    fun btnNumberFive() {
        appendOnResultView("5", true)
    }

    fun btnNumberSix() {
        appendOnResultView("6", true)
    }

    fun btnNumberSeven() {
        appendOnResultView("7", true)
    }

    fun btnNumberEight() {
        appendOnResultView("8", true)
    }

    fun btnNumberNine() {
        appendOnResultView("9", true)
    }

    fun btnNumberZero() {
        appendOnResultView("0", true)
    }


    /**
     * sign Dot
     */

    fun btnSignDot() {
        if (lastDigit.isEmpty()) {
            lastDigit = "0."
        }

        appendOnResultView(".", true)
    }


    /**
     *  Operators
     */

    fun btnOpDivision() {
        appendOnResultView("÷", false)
    }

    fun btnOpMultiplication() {
        appendOnResultView("-", false)
    }

    fun btnOpSubtraction() {
        appendOnResultView("×", false)
    }

    fun btnOpAddition() {
        appendOnResultView("+", false)
    }


    private fun appendOnResultView(string: String, isDigitOrOperation: Boolean) {
        if (isDigitOrOperation) {
            when {
                lastDigit == "0" -> lastDigit = string
                lastDigit == resultRemember.toString() -> lastDigit = string
                else -> lastDigit += string
            }
            result.value = lastDigit
            lastStringIsDigitOrOp = true

        } else {

            if (lastStringIsDigitOrOp) {
                currentOperator = string
                opCount++

                if (lastDigit.isEmpty()) lastDigit = "0"


                if (opCount == 1) {
                    resultRemember = lastDigit.toDouble()

                } else {
                    calculate(prevOperator)

                }
            } else {


                prevOperator = currentOperator

            }
            lastStringIsDigitOrOp = false
            lastDigit = ""
            prevOperator = currentOperator

        }

    }

    private fun calculate(string: String) {
        when (string) {
            "+" -> {
                resultRemember += lastDigit.toDouble()
                result.value = resultRemember.toString()
            }
        }

    }


}


