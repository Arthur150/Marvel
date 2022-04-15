package com.example.marvel.data.datasource

import com.example.marvel.data.networking.CharacterService

class CharacterRemoteDataSourceImpl(val characterService: CharacterService) : CharacterRemoteDataSource {
    override fun getAllCharacter() {
        TODO("Not yet implemented")
    }
}