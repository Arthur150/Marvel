package com.example.marvel.domain

import com.example.marvel.provider.ObjectProvider
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.get
import kotlin.test.assertEquals

class GetCharacterComicsUseCaseTest: KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*DomainModulesTest.all)
    }

    @Test
    operator fun invoke() = runBlocking {

        val getUserUseCase = get<GetCharacterComicsUseCase>()
        val actual = getUserUseCase(1009368)
        val expected = ObjectProvider.marvelComicsListPageOne.data.results

        assertEquals(expected, actual)
    }
}