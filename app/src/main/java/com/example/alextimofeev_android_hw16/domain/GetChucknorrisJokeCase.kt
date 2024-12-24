package com.example.alextimofeev_android_hw16.domain

import com.example.alextimofeev_android_hw16.data.ChuckNorrisDtoSource
import com.example.alextimofeev_android_hw16.entity.ChuckNorrisJoke
import javax.inject.Inject

class GetChuckNorrisJokeCase @Inject constructor(
    private val source: ChuckNorrisDtoSource
) {
    suspend fun execute() : ChuckNorrisJoke{
        return source.getChuckJoke()
    }
}