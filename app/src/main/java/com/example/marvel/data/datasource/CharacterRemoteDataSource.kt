package com.example.marvel.data.datasource

import com.example.marvel.model.MarvelCharacter
import com.example.marvel.model.MarvelComic

interface CharacterRemoteDataSource {
    suspend fun getAllCharacter(offset: Int): Result<Pair<Int, List<MarvelCharacter>>>
    suspend fun getCharacter(id: Int): Result<MarvelCharacter>
    suspend fun getCharacterComics(id: Int): Result<List<MarvelComic>?>
}