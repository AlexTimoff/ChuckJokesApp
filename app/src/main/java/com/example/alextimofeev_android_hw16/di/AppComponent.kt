package com.example.alextimofeev_android_hw16.di

import com.example.alextimofeev_android_hw16.presentation.MainFragment
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        DataSourceModule::class,
        RepositoryModule::class
    ]
)

@Singleton
interface AppComponent {
    fun injectMainFragment(fragment: MainFragment)
}