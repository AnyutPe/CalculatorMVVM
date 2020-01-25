package com.example.studyingmvvm.viewModels.standardCalc.implementation

import com.example.studyingmvvm.core.Calculator
import com.example.studyingmvvm.viewModels.base.ParametrizedCommand
import com.example.studyingmvvm.viewModels.standardCalc.StandardCalcViewModel

class AddNumberCommand(
    private val viewModel: StandardCalcViewModel,
    private val calculator: Calculator
) : ParametrizedCommand<Char>() {

    override fun execute(parameter: Char) {
        viewModel.result.value = calculator.addNumber(parameter)
    }
}