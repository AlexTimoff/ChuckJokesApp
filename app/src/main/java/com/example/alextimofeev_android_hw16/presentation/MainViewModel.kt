package com.example.alextimofeev_android_hw16.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alextimofeev_android_hw16.domain.GetChuckNorrisJokeCase
import com.example.alextimofeev_android_hw16.entity.ChuckNorrisJoke
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val getChuckNorrisJokeCase: GetChuckNorrisJokeCase
): ViewModel(

) {
    private var startJokeActivity = true
    private val _jokeActivity = MutableStateFlow<ChuckNorrisJoke?>(null)
    val jokeActivity: StateFlow<ChuckNorrisJoke?> = _jokeActivity

    fun firstJoke() {
        if (startJokeActivity) {
            reloadJoke()
            startJokeActivity = false
        }
    }

    fun reloadJoke() {
        viewModelScope.launch {
            try {
                val activity = getChuckNorrisJokeCase.execute()
                _jokeActivity.value = activity
            } catch (ex: Exception) {
                _jokeActivity.value = null
                println("Error: ${ex.message}")
                ex.printStackTrace()
            }
        }
    }
}