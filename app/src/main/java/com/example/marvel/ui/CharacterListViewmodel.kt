package com.example.marvel.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.GetAllCharacterUseCase
import com.example.marvel.model.MarvelCharacter
import kotlinx.coroutines.launch

class CharacterListViewmodel(val getAllCharacterUseCase: GetAllCharacterUseCase) : ViewModel() {
    private val characterList: MutableLiveData<List<MarvelCharacter>> by lazy {
        MutableLiveData<List<MarvelCharacter>>().also {
            loadCharacter()
        }
    }

    fun getCharacterList(): LiveData<List<MarvelCharacter>> {
        return characterList
    }

    fun loadCharacter() {
        viewModelScope.launch {
            characterList.postValue(getAllCharacterUseCase())
        }
    }
}