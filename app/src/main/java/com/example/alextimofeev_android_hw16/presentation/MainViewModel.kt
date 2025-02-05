package com.example.alextimofeev_android_hw16.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alextimofeev_android_hw16.domain.GetChuckNorrisJokeUseCase
import com.example.alextimofeev_android_hw16.presentation.state.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class MainViewModel(
    private val getChuckNorrisJokeUseCase: GetChuckNorrisJokeUseCase
) : ViewModel(

) {
    private var startJokeActivity = true

    private val _state = MutableStateFlow<State>(State.Loading)
    val state = _state.asStateFlow()

    fun firstJoke() {
        if (startJokeActivity) {
            reloadJoke()
            startJokeActivity = false
        }
    }

    fun reloadJoke() {
        viewModelScope.launch {
            _state.value = State.Loading
            try {
                val chuckNorrisJoke = getChuckNorrisJokeUseCase.fetchChuckJoke()
                if (chuckNorrisJoke != null) {
                    _state.value = State.Success(chuckNorrisJoke)
                } else {
                    _state.value = State.RequestNotCompleted
                }
            } catch (e: Throwable) {
                _state.value = State.Error(e.message.toString())
            }
        }
    }
}