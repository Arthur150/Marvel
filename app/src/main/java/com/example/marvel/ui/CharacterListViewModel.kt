package com.example.marvel.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.marvel.domain.GetAllCharacterUseCase
import com.example.marvel.model.MarvelCharacter

class CharacterListViewModel(val getAllCharacterUseCase: GetAllCharacterUseCase) : ViewModel() {
    val characterList: LiveData<List<MarvelCharacter>> = liveData {
        emit(getAllCharacterUseCase())
    }
}