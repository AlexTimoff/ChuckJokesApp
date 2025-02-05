package com.example.alextimofeev_android_hw16.domain

import com.example.alextimofeev_android_hw16.domain.entity.ChuckNorrisJoke

interface ApiRepository {
    suspend fun fetchChuckJoke(): ChuckNorrisJoke?
}