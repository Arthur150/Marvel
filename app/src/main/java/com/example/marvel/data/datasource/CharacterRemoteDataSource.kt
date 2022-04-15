package com.example.marvel.data.datasource

import com.example.marvel.model.MarvelCharacter

interface CharacterRemoteDataSource {
    suspend fun getAllCharacter(): Result<List<MarvelCharacter>>
}