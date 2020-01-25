package com.example.studyingmvvm.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studyingmvvm.core.Calculator

class StandardCalcViewModel : ViewModel() {
    private val standardCalcModel =
        Calculator()

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
    fun addDot() {
        result.value = standardCalcModel.addDot()
    }

    /**
     *  Operators
     */
    fun addOperator(operator: Char) {
        result.value = standardCalcModel.addOperator(operator)

    }

}


