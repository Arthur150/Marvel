package com.example.marvel.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.marvel.data.datasource.CharacterRemoteDataSource
import com.example.marvel.data.paging.CharacterPagingSource
import com.example.marvel.model.MarvelCharacter
import kotlinx.coroutines.flow.Flow

class CharacterRepositoryImpl(private val characterRemoteDataSource: CharacterRemoteDataSource) :
    CharacterRepository {
    override fun getPaginatedCharacter(): Flow<PagingData<MarvelCharacter>> {
        return Pager(PagingConfig(20)) {
            CharacterPagingSource(characterRemoteDataSource)
        }.flow
    }
}