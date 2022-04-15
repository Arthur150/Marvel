package com.example.marvel.data.repository

import com.example.marvel.data.datasource.CharacterRemoteDataSource

class CharacterRepositoryImpl(val characterRemoteDataSource: CharacterRemoteDataSource) : CharacterRepository {
    override fun getPaginatedCharacter() {
        TODO("Not yet implemented")
    }
}