package com.example.marvel.domain

import com.example.marvel.data.repository.CharacterRepository
import com.example.marvel.model.MarvelCharacter

class GetCharacterUseCase(private val characterRepository: CharacterRepository) {
    suspend operator fun invoke(id: Int): MarvelCharacter? {
        return characterRepository.getCharacter(id)
    }
}