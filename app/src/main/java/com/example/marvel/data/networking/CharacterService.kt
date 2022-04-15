package com.example.marvel.data.networking

import com.example.marvel.model.JsonResponse
import com.example.marvel.model.MarvelCharacter
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int
    ): Response<JsonResponse<MarvelCharacter>>
}