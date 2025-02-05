package com.example.alextimofeev_android_hw16.domain

import com.example.alextimofeev_android_hw16.domain.entity.ChuckNorrisJoke
import javax.inject.Inject

class GetChuckNorrisJokeUseCase @Inject constructor(
    private val apiRepository: ApiRepository
) {
    suspend fun fetchChuckJoke(): ChuckNorrisJoke? {
        return apiRepository.fetchChuckJoke()
    }
}