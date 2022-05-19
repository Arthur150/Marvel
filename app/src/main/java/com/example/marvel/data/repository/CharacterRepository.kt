package com.example.marvel.data.repository

import androidx.paging.PagingData
import com.example.marvel.model.MarvelCharacter
import com.example.marvel.model.MarvelComic
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getPaginatedCharacter(): Flow<PagingData<MarvelCharacter>>
    suspend fun getCharacter(id: Int): MarvelCharacter?
    suspend fun getCharacterComics(id: Int): List<MarvelComic>?
}