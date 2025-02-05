package com.example.alextimofeev_android_hw16.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChuckNorrisJokeDto(
    @Json(name="icon_url") val iconUrl: String?,
    @Json(name="value") val joke: String?
)
