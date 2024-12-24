package com.example.alextimofeev_android_hw16.data

import com.example.alextimofeev_android_hw16.entity.ChuckNorrisJoke
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ChuckNorrisJokeDto(
    @Json(name="icon_url") override val iconUrl: String,
    @Json(name="value") override val joke: String
):ChuckNorrisJoke
