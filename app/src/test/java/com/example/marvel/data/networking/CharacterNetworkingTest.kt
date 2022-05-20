package com.example.marvel.data.networking

import android.util.Log
import com.example.marvel.manager.ResourcesManager
import com.example.marvel.model.JsonResponse
import com.example.marvel.model.MarvelCharacter
import com.example.marvel.provider.ObjectProvider
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import kotlin.test.assertEquals

class CharacterNetworkingTest: KoinTest {
    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*NetworkingModulesTest.all)
    }

    private val server by inject<MockWebServer>()
    private val source by inject<CharacterService>()

    @Test
    fun getAllCharactersPageOne() = runBlocking {
        val expected = MockResponse().apply {
            setResponseCode(200)
            setBody(ResourcesManager.loadResource("get_characters_list.json"))
        }
        server.enqueue(expected)

        val actual: JsonResponse<MarvelCharacter>? = source.getCharacters(0).body()

        assertEquals(ObjectProvider.marvelCharacterListPageOne, actual)
    }

    @Test
    fun getCharacter() = runBlocking {
        val expected = MockResponse().apply {
            setResponseCode(200)
            setBody(ResourcesManager.loadResource("get_character.json"))
        }
        server.enqueue(expected)

        val actual = source.getCharacter(1009368).body()

        assertEquals(ObjectProvider.marvelCharacter, actual)
    }
}