package com.example.marvel.provider

import com.example.marvel.manager.ResourcesManager
import com.example.marvel.model.JsonResponse
import com.example.marvel.model.MarvelCharacter
import com.example.marvel.model.MarvelComic
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ObjectProvider {

    val marvelCharacter: JsonResponse<MarvelCharacter> = Gson().fromJson(
        ResourcesManager.loadResource("get_character.json"),
        object : TypeToken<JsonResponse<MarvelCharacter>>() {}.type
    )

    val marvelCharacterListPageOne: JsonResponse<MarvelCharacter> = Gson().fromJson(
        ResourcesManager.loadResource("get_characters_list.json"),
        object : TypeToken<JsonResponse<MarvelCharacter>>() {}.type
    )

    val marvelComicsListPageOne: JsonResponse<MarvelComic> = Gson().fromJson(
        ResourcesManager.loadResource("get_character_comics.json"),
        object : TypeToken<JsonResponse<MarvelComic>>() {}.type
    )
}