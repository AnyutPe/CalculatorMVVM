package com.example.studyingmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StandardCalcViewModel : ViewModel() {
    private val standardCalcModel = StandardCalcModel()

    var result = MutableLiveData<String>("0")


    /**
     * Numbers
     */
    fun addNumber(number: Char) {
      result.value = standardCalcModel.addNumber(number)
    }

    /**
     * sign Dot
     */
    fun addDot(number: Char) {
        result.value = standardCalcModel.addDot(number)
    }

    /**
     *  Operators
     */
    fun addOperator(operator: Char) {
        result.value = standardCalcModel.addOperator(operator)

    }

}


