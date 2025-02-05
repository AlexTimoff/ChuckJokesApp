package com.example.alextimofeev_android_hw16.domain

import com.example.alextimofeev_android_hw16.data.entity.ChuckNorrisJokeDto
import com.example.alextimofeev_android_hw16.domain.entity.ChuckNorrisJoke

fun mapChuckNorrisJokeDtoToChuckNorrisJoke(chuckNorrisJokeDto: ChuckNorrisJokeDto): ChuckNorrisJoke {
    return ChuckNorrisJoke(
        iconUrl = chuckNorrisJokeDto.iconUrl,
        joke = chuckNorrisJokeDto.joke
    )
}