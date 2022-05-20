package com.example.marvel.domain

import com.example.marvel.data.repository.CharacterRepository
import com.example.marvel.model.MarvelCharacter
import com.example.marvel.model.MarvelComic

class GetCharacterComicsUseCase(private val characterRepository: CharacterRepository) {
    suspend operator fun invoke(id: Int): List<MarvelComic>? {
        return characterRepository.getCharacterComics(id)
    }
}