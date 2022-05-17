package com.example.marvel.data.networking

import com.example.marvel.model.JsonResponse
import com.example.marvel.model.MarvelCharacter
import com.example.marvel.model.MarvelComic
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int
    ): Response<JsonResponse<MarvelCharacter>>

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacter(
        @Path("id") characterId: Int
    ): Response<JsonResponse<MarvelCharacter>>

    @GET("/v1/public/characters/{id}/comics")
    suspend fun getCharacterComics(
        @Path("id") characterId: Int,
        @Query("offset") offset: Int
    ): Response<JsonResponse<MarvelComic>>
}