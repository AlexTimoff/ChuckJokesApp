package com.example.alextimofeev_android_hw16.di

import com.example.alextimofeev_android_hw16.data.GetChuckNorrisJokeResponse
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.chucknorris.io"

@Module
class DataSourceModule {

    @Provides
    @Singleton
    fun provideRetrofit(): GetChuckNorrisJokeResponse {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GetChuckNorrisJokeResponse::class.java)
    }

}