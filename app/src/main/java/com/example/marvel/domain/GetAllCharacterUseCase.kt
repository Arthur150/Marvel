package com.example.marvel.domain

import com.example.marvel.data.repository.CharacterRepository
import com.example.marvel.model.MarvelCharacter

class GetAllCharacterUseCase(private val characterRepository: CharacterRepository) {

    suspend operator fun invoke(): List<MarvelCharacter> {
        return characterRepository.getPaginatedCharacter()
    }
}