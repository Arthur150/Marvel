package com.example.marvel.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.marvel.domain.GetAllCharacterUseCase
import com.example.marvel.model.MarvelCharacter
import kotlinx.coroutines.flow.Flow

class CharacterListViewModel(private val getAllCharacterUseCase: GetAllCharacterUseCase) :
    ViewModel() {
    val characterList: Flow<PagingData<MarvelCharacter>> =
        getAllCharacterUseCase().cachedIn(viewModelScope)
}