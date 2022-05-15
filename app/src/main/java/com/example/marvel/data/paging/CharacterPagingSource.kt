package com.example.marvel.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.marvel.data.datasource.CharacterRemoteDataSource
import com.example.marvel.model.MarvelCharacter

class CharacterPagingSource(
    private val marvelDataSource: CharacterRemoteDataSource
) : PagingSource<Int, MarvelCharacter>() {

    override fun getRefreshKey(state: PagingState<Int, MarvelCharacter>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MarvelCharacter> {
        return try {
            val nextOffset = params.key ?: 0
            val response = marvelDataSource.getAllCharacter(nextOffset).getOrNull()
            LoadResult.Page(
                data = response?.second ?: emptyList(),
                prevKey = null,
                nextKey = response?.first
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}