package com.example.alextimofeev_android_hw16.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.alextimofeev_android_hw16.domain.GetChuckNorrisJokeUseCase
import java.lang.IllegalArgumentException
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val getChuckNorrisJokeUseCase: GetChuckNorrisJokeUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(getChuckNorrisJokeUseCase) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}