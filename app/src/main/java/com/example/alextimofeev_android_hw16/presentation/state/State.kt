package com.example.alextimofeev_android_hw16.presentation.state

import com.example.alextimofeev_android_hw16.domain.entity.ChuckNorrisJoke

sealed class State {
    data object Loading : State()
    data object RequestNotCompleted : State()
    data class Success(val chuckNorrisJoke: ChuckNorrisJoke) : State()
    data class Error(val error: String) : State()
}