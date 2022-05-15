package com.example.marvel.data.datasource

import com.example.marvel.model.MarvelCharacter

interface CharacterRemoteDataSource {
    suspend fun getAllCharacter(offset: Int): Result<Pair<Int, List<MarvelCharacter>>>
}