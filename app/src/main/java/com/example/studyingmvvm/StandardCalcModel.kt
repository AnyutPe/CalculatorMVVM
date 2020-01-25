package com.example.studyingmvvm

class StandardCalcModel {

    enum class OperandKind {
        Digit,
        Operation
    }

    private var lastNumber: String = ""

    private var countOfOperators: Int = 0
    private var resultRemember: Double = 0.0

    private var previousOperator: String = ""
    private var currentOperator: String = ""

    private var lastOperandKind = OperandKind.Digit

    /**
     * Numbers
     */
    fun addNumber(number: Char): String {
        return appendToResult(number, OperandKind.Digit)
    }

    /**
     * sign Dot
     */
    fun addDot(): String {
        if (lastNumber.isEmpty()) {
            lastNumber = "0."
        } else if (!lastNumber.contains('.')) {
            return appendToResult('.', OperandKind.Digit)
        }
        return lastNumber
    }

    /**
     *  Operators
     */
    fun addOperator(operator: Char): String {
        return appendToResult(operator, OperandKind.Operation)
    }

    private fun appendToResult(operatorOrDigit: Char, operandKind: OperandKind): String {
        var result = lastNumber

        when (operandKind) {
            OperandKind.Digit -> {
                when (lastNumber) {
                    "0" -> lastNumber = operatorOrDigit.toString()
                    resultRemember.toString() -> lastNumber = operatorOrDigit.toString()
                    else -> lastNumber += operatorOrDigit
                }
                result = lastNumber
                lastOperandKind = OperandKind.Digit
            }
            OperandKind.Operation -> {
                when (lastOperandKind) {
                    OperandKind.Digit -> {
                        currentOperator = operatorOrDigit.toString()
                        countOfOperators++

                        if (lastNumber.isEmpty()) lastNumber = "0"

                        if (countOfOperators == 1) {
                            resultRemember = lastNumber.toDouble()
                        } else {
                            result = calculate(previousOperator)
                        }
                    }
                    OperandKind.Operation -> {
                        if (previousOperator == currentOperator) {
                            countOfOperators--
                            result = resultRemember.toString()
                        }
                    }
                }

                lastOperandKind = OperandKind.Operation
                lastNumber = ""
                previousOperator = currentOperator
            }
        }
        return result
    }


    private fun calculate(string: String): String {
        var result = ""
        when (string) {
            "+" -> {
                resultRemember += lastNumber.toDouble()
                result = resultRemember.toString()
            }
        }

        return result
    }

}


