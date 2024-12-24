package com.example.alextimofeev_android_hw16.data

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.chucknorris.io"

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val getChuckNorrisJokeResponse: GetChuckNorrisJokeResponse = retrofit.create(
        GetChuckNorrisJokeResponse::class.java)
}
interface GetChuckNorrisJokeResponse{
    @GET("/jokes/random")
    suspend fun getChuckNorrisJoke(): Response<ChuckNorrisJokeDto>
}