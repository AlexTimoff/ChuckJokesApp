package com.example.alextimofeev_android_hw16.data

import android.util.Log
import com.example.alextimofeev_android_hw16.entity.ChuckNorrisJoke
import javax.inject.Inject

class ChuckNorrisDtoSource @Inject constructor(){
    private var chuckJoke = ChuckNorrisJokeDto(
        iconUrl = "not found",
        joke = "not found"
    )

    suspend fun getChuckJoke(): ChuckNorrisJoke {
        try {
            val response = RetrofitInstance.getChuckNorrisJokeResponse.getChuckNorrisJoke()
            if (response.isSuccessful) {
                chuckJoke= response.body()!!
            }

        } catch (ex: Exception) {
            Log.d("log", "${ex.message}")
        }
        return chuckJoke
    }
}