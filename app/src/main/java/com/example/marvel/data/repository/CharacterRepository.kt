package com.example.marvel.data.repository

import com.example.marvel.model.MarvelCharacter

interface CharacterRepository {
    suspend fun getPaginatedCharacter(): List<MarvelCharacter>?
}