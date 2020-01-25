package com.example.studyingmvvm.viewModels.standardCalc.implementation

import com.example.studyingmvvm.core.Calculator
import com.example.studyingmvvm.viewModels.base.Command
import com.example.studyingmvvm.viewModels.standardCalc.StandardCalcViewModel

class AddDotCommand (
    private val viewModel: StandardCalcViewModel,
    private val calculator: Calculator
) : Command(true) {

    init {
        viewModel.result.observeForever {
            canExecute.value = !it.contains(".")
        }
    }

    override fun execute() {
        viewModel.result.value = calculator.addDot()
    }
}