package com.example.dadjokesgenerator.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dadjokesgenerator.screen.main.repository.JokesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainScreenViewModel : ViewModel(), KoinComponent {
    private val repository: JokesRepository by inject()
    private val _state = MutableStateFlow(MainScreenState())
    val state = _state.asStateFlow()

    init {
        getJokes()
    }

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.OnNextClicked -> {
                getJokes()
            }
        }
    }

    private fun getJokes() {
        viewModelScope.launch {
            repository.getJokes().onSuccess { response ->
                _state.value = MainScreenState(joke = response.joke)
            }.onFailure { e ->
                e.printStackTrace()
            }
        }
    }
}
