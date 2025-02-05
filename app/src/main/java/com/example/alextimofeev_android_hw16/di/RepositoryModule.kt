package com.example.alextimofeev_android_hw16.di

import com.example.alextimofeev_android_hw16.data.ApiRepositoryImpl
import com.example.alextimofeev_android_hw16.domain.ApiRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindsApiRepository(repository: ApiRepositoryImpl): ApiRepository
}