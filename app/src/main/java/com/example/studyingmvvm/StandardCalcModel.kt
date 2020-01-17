package com.example.studyingmvvm

class StandardCalcModel {

    enum class OperandKind {
        Digit,
        Operation
    }

    private var lastDigit: String = ""

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
    fun addDot(number: Char): String {
        if (lastDigit.isEmpty()) {
            lastDigit = "0."
        } else {
            return if (lastDigit.contains('.')) {
                ""
            } else {
                return appendToResult('.', OperandKind.Digit)
            }
        }
        return ""
    }

    /**
     *  Operators
     */
    fun addOperator(operator: Char): String {
        return appendToResult(operator, OperandKind.Operation)
    }

    private fun appendToResult(operatorOrDigit: Char, operandKind: OperandKind): String {
        var result = lastDigit

        when (operandKind) {
            OperandKind.Digit -> {
                when (lastDigit) {
                    "0" -> lastDigit = operatorOrDigit.toString()
                    resultRemember.toString() -> lastDigit = operatorOrDigit.toString()
                    else -> lastDigit += operatorOrDigit
                }
                result = lastDigit
                lastOperandKind = OperandKind.Digit
            }
            OperandKind.Operation -> {
                when(lastOperandKind) {
                    OperandKind.Digit -> {
                        currentOperator = operatorOrDigit.toString()
                        countOfOperators++

                        if (lastDigit.isEmpty()) lastDigit = "0"

                        if (countOfOperators == 1) {
                            resultRemember = lastDigit.toDouble()
                        } else {
                            result = calculate(previousOperator)
                        }
                    }
                    OperandKind.Operation -> {
                        if (previousOperator == currentOperator) {
                            countOfOperators--
                        }
                    }
                }

                lastOperandKind = OperandKind.Operation
                lastDigit = ""
                previousOperator = currentOperator
            }
        }
        return result
    }


    private fun calculate(string: String): String {
        var result: String = ""
        when (string) {
            "+" -> {
                resultRemember += lastDigit.toDouble()
                result = resultRemember.toString()
            }
        }
        return result
    }
}


