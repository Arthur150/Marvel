package com.example.marvel.ui

import androidx.lifecycle.*
import com.example.marvel.domain.GetAllCharacterUseCase
import com.example.marvel.model.MarvelCharacter
import kotlinx.coroutines.launch

class CharacterListViewModel(val getAllCharacterUseCase: GetAllCharacterUseCase) : ViewModel() {
    val characterList: LiveData<List<MarvelCharacter>> = liveData {
        emit(getAllCharacterUseCase())
    }
}