package com.myapp.secondfilm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _text = MutableStateFlow("Hello from ViewModel!")
    val text: StateFlow<String> = _text.asStateFlow()

    fun updateText(newText: String) {
        _text.value = newText
    }
}