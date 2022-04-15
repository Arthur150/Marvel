package com.example.marvel.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvel.domain.GetAllCharacterUseCase
import com.example.marvel.model.MarvelCharacter

class CharacterListViewmodel (val getAllCharacterUseCase: GetAllCharacterUseCase): ViewModel() {
    private val characterList: MutableLiveData<List<MarvelCharacter>> by lazy {
        MutableLiveData<List<MarvelCharacter>>()
    }

    fun getCharacterList(): LiveData<List<MarvelCharacter>> {
        return characterList
    }

    fun loadCharacter(){

    }
}