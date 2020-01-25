package com.example.studyingmvvm.viewModels.base

import androidx.lifecycle.MutableLiveData

abstract class Command(canExecute: Boolean = true) {
    val canExecute = MutableLiveData(canExecute)
    abstract fun execute()
}

