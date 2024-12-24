package com.example.alextimofeev_android_hw16.di

import com.example.alextimofeev_android_hw16.presentation.MainViewModelFactory
import dagger.Component

@Component
interface AppComponent {
    fun mainViewModelFactory(): MainViewModelFactory
}