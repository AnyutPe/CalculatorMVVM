package com.example.studyingmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StandardCalcViewModel : ViewModel() {
    var result = MutableLiveData<String>("0")

    private var lastDigit: String = ""

    private var countOfOperators: Int = 0
    private var resultRemember: Double = 0.0

    private var previousOperator: String = ""
    private var currentOperator: String = ""

    private var lastStringIsDigitOrOperator: Boolean = true


    /**
     * Numbers
     */
    fun addNumber(number: Char) {
        appendOnResultView(number, true)
    }

    /**
     * sign Dot
     */
    fun addDot(number: Char) {
        if (lastDigit.isEmpty()) {
            lastDigit = "0."
        }else{
            if(lastDigit.contains('.')){
                return
            }else{
                appendOnResultView('.', true)
            }

        }
    }

    /**
     *  Operators
     */
    fun addOperator(operator: Char) {
        appendOnResultView(operator, false)
    }

    private fun appendOnResultView(operatorOrDigit: Char, isDigitOrOperation: Boolean) {
        if (isDigitOrOperation) {
            when (lastDigit) {
                "0" -> lastDigit = operatorOrDigit.toString()
                resultRemember.toString() -> lastDigit = operatorOrDigit.toString()
                else -> lastDigit += operatorOrDigit
            }
            result.value = lastDigit
            lastStringIsDigitOrOperator = true
        } else {

            if (lastStringIsDigitOrOperator) {
                currentOperator = operatorOrDigit.toString()
                countOfOperators++

                if (lastDigit.isEmpty()) lastDigit = "0"

                if (countOfOperators == 1) {
                    resultRemember = lastDigit.toDouble()
                } else {
                    calculate(previousOperator)
                }
            } else {
                if(previousOperator == currentOperator) {
                    countOfOperators--
                }
            }
            lastStringIsDigitOrOperator = false
            lastDigit = ""
            previousOperator = currentOperator
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


