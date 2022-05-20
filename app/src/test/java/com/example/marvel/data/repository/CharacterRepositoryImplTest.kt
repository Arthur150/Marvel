package com.example.marvel.data.repository

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.example.marvel.provider.ObjectProvider
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import kotlin.test.assertEquals
import androidx.paging.PagingSource.LoadResult.Page
import androidx.paging.PagingSource.LoadParams.Refresh
import com.example.marvel.data.paging.CharacterPagingSource

class CharacterRepositoryImplTest: KoinTest {
    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*RepositoryModulesTest.all)
    }

    private val characterRepository by inject<CharacterRepository>()
    private val characterPagingSource by inject<CharacterPagingSource>()

    @Test
    fun getPaginatedCharacter() = runBlocking {

    }

    @Test
    fun getCharacter() = runBlocking {

        val actual = characterRepository.getCharacter(1009368)
        val expected = ObjectProvider.marvelCharacter.data.results.first()

        assertEquals(expected, actual)
    }

    @Test
    fun getCharacterComics() = runBlocking {

        val actual = characterRepository.getCharacterComics(1009368)
        val expected = ObjectProvider.marvelComicsListPageOne.data.results

        assertEquals(expected, actual)
    }
}