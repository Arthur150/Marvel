package com.example.marvel.data.repository

import androidx.paging.PagingData
import com.example.marvel.model.MarvelCharacter
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getPaginatedCharacter(): Flow<PagingData<MarvelCharacter>>
    suspend fun getCharacter(id: Int): MarvelCharacter?
}