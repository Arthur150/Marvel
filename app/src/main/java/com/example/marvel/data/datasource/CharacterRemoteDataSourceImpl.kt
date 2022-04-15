package com.example.marvel.data.datasource

import com.example.marvel.data.networking.CharacterService
import com.example.marvel.model.JsonResponse
import com.example.marvel.model.MarvelCharacter
import retrofit2.Response

class CharacterRemoteDataSourceImpl(private val characterService: CharacterService) :
    CharacterRemoteDataSource {
    override suspend fun getAllCharacter(): List<MarvelCharacter> {
        return try {
            val response: Response<JsonResponse<MarvelCharacter>> =
                characterService.getCharacters(0)

            if (response.isSuccessful) {
                response.body()?.data?.results ?: throw IllegalStateException("Body is null")
            } else {
                throw IllegalStateException("${response.code()}")
            }
        } catch (t: Throwable) {
            emptyList()
        }
    }
}