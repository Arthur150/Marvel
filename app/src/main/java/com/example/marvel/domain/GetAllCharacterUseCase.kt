package com.example.marvel.domain

import androidx.paging.PagingData
import com.example.marvel.data.repository.CharacterRepository
import com.example.marvel.model.MarvelCharacter
import kotlinx.coroutines.flow.Flow

class GetAllCharacterUseCase(private val characterRepository: CharacterRepository) {

    operator fun invoke(): Flow<PagingData<MarvelCharacter>> {
        return characterRepository.getPaginatedCharacter()
    }
}