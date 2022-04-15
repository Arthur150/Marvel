package com.example.marvel.data.repository

import com.example.marvel.data.datasource.CharacterRemoteDataSource
import com.example.marvel.model.MarvelCharacter

class CharacterRepositoryImpl(private val characterRemoteDataSource: CharacterRemoteDataSource) :
    CharacterRepository {
    override suspend fun getPaginatedCharacter(): List<MarvelCharacter>? {
        return characterRemoteDataSource.getAllCharacter().getOrNull()
    }
}