package com.example.studyingmvvm.viewModels.standardCalc

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studyingmvvm.core.Calculator
import com.example.studyingmvvm.viewModels.standardCalc.implementation.AddDotCommand
import com.example.studyingmvvm.viewModels.standardCalc.implementation.AddNumberCommand
import com.example.studyingmvvm.viewModels.standardCalc.implementation.AddOperatorCommand

class StandardCalcViewModel : ViewModel() {
    private val calculator = Calculator()

    var result = MutableLiveData<String>("0")

    val addDotCommand = AddDotCommand(this, calculator)
    val addNumberCommand = AddNumberCommand(this, calculator)
    val addOperatorCommand = AddOperatorCommand(this, calculator)
}


