package com.example.marvel.data.datasource

import com.example.marvel.model.MarvelCharacter
import com.example.marvel.model.MarvelComic
import com.example.marvel.provider.ObjectProvider
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import kotlin.test.assertEquals

class CharacterRemoteDataSourceImplTest: KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*DataSourceModulesTest.all)
    }

    private val characterRemoteDataSource by inject<CharacterRemoteDataSource>()

    @Test
    fun getCharacterList() = runBlocking {
        val actual = characterRemoteDataSource.getAllCharacter(0).getOrNull()
        val expected = Pair<Int, List<MarvelCharacter>>(
            20,
            ObjectProvider.marvelCharacterListPageOne.data.results
        )
        assertEquals(expected, actual)
    }

    @Test
    fun getCharacter() = runBlocking {

        val actual = characterRemoteDataSource.getCharacter(1009368).getOrNull()
        val expected = ObjectProvider.marvelCharacter.data.results.first()

        assertEquals(expected, actual)
    }

    @Test
    fun getCharacterComics() = runBlocking {
        val actual = characterRemoteDataSource.getCharacterComics(1009368).getOrNull()
        val expected = ObjectProvider.marvelComicsListPageOne.data.results
        assertEquals(expected, actual)
    }
}