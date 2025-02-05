package com.example.alextimofeev_android_hw16.data

import com.example.alextimofeev_android_hw16.data.entity.ChuckNorrisJokeDto
import retrofit2.Response
import retrofit2.http.GET

interface GetChuckNorrisJokeResponse{
    @GET("/jokes/random")
    suspend fun getChuckNorrisJoke(): Response<ChuckNorrisJokeDto>
}