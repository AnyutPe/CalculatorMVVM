package com.example.studyingmvvm.viewModels.base

import androidx.lifecycle.MutableLiveData

abstract class ParametrizedCommand<in T>(canExecute: Boolean = true) {
    val canExecute = MutableLiveData(canExecute)
    abstract fun execute(parameter: T)
}