package com.example.marvel.ui.characterDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.GetCharacterUseCase
import com.example.marvel.model.MarvelCharacter
import kotlinx.coroutines.launch

class CharacterDetailViewModel(private val getCharacterUseCase: GetCharacterUseCase): ViewModel() {
    private val character = MutableLiveData<MarvelCharacter>()

    fun getCharacter(): LiveData<MarvelCharacter>{
        return character
    }

    fun loadCharacter(id: Int){
        viewModelScope.launch {
            character.postValue(getCharacterUseCase.invoke(id))
        }
    }
}