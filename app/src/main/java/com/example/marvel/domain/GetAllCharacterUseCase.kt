package com.example.marvel.domain

import com.example.marvel.data.repository.CharacterRepository
import com.example.marvel.model.JsonResponse
import com.example.marvel.model.MarvelCharacter

class GetAllCharacterUseCase(val characterRepository: CharacterRepository) {

    operator fun invoke() {

    }
}