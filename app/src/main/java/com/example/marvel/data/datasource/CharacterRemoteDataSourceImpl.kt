package com.example.marvel.data.datasource

import com.example.marvel.data.networking.CharacterService
import com.example.marvel.model.JsonResponse
import com.example.marvel.model.MarvelCharacter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Response
import java.lang.IllegalStateException

class CharacterRemoteDataSourceImpl(private val characterService: CharacterService) :
    CharacterRemoteDataSource {
    override suspend fun getAllCharacter(): Result<List<MarvelCharacter>> {
        return try {
            val response: Response<JsonResponse<MarvelCharacter>> = characterService.getCharacters(0)

            if (response.isSuccessful){
                val jsonResponse = Gson().fromJson<JsonResponse<MarvelCharacter>>(
                    Gson().toJson(response.body()),
                    object : TypeToken<JsonResponse<MarvelCharacter>>() {}.type
                )
                Result.success(jsonResponse.data.results)
            } else {
                throw IllegalStateException("${response.code()}")
            }
        }
        catch (t: Throwable){
            Result.failure(t)
        }
    }
}