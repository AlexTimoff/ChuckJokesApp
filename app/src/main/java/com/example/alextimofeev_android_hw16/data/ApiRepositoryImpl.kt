package com.example.alextimofeev_android_hw16.data

import com.example.alextimofeev_android_hw16.domain.ApiRepository
import com.example.alextimofeev_android_hw16.domain.entity.ChuckNorrisJoke
import com.example.alextimofeev_android_hw16.domain.mapChuckNorrisJokeDtoToChuckNorrisJoke
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val dataSource: ChuckNorrisDataSource
) : ApiRepository {
    override suspend fun fetchChuckJoke(): ChuckNorrisJoke? {
        val chuckNorrisJokeDto = dataSource.getChuckJoke()
        return if (chuckNorrisJokeDto == null) null else mapChuckNorrisJokeDtoToChuckNorrisJoke(chuckNorrisJokeDto)
    }
}