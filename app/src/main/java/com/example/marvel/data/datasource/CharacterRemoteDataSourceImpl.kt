package com.example.marvel.data.datasource

import com.example.marvel.data.networking.CharacterService
import com.example.marvel.model.JsonResponse
import com.example.marvel.model.MarvelCharacter
import retrofit2.Response

class CharacterRemoteDataSourceImpl(private val characterService: CharacterService) :
    CharacterRemoteDataSource {
    override suspend fun getAllCharacter(offset: Int): Result<Pair<Int, List<MarvelCharacter>>> {
        return try {
            val response: Response<JsonResponse<MarvelCharacter>> =
                characterService.getCharacters(offset)

            if (response.isSuccessful) {
                val nextOffset = response.body()?.data?.offset?.plus(20) ?: offset
                val characterList = response.body()?.data?.results
                Result.success(Pair(nextOffset, characterList ?: emptyList()))
            } else {
                throw IllegalStateException(response.message())
            }
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}