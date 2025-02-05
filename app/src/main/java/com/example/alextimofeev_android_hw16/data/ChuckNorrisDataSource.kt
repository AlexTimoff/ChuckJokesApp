package com.example.alextimofeev_android_hw16.data

import android.util.Log
import com.example.alextimofeev_android_hw16.data.entity.ChuckNorrisJokeDto
import javax.inject.Inject

class ChuckNorrisDataSource @Inject constructor(
    private val api: GetChuckNorrisJokeResponse
) {
    suspend fun getChuckJoke(): ChuckNorrisJokeDto? {
        try {
            val response = api.getChuckNorrisJoke()
            if (response.isSuccessful) {
                return response.body()!!
            }

        } catch (ex: Exception) {
            Log.d("ChuckNorrisDataSource", "${ex.message}")
        }
        return null
    }
}