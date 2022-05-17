package com.example.marvel.ui.characterDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.GetCharacterComicsUseCase
import com.example.marvel.domain.GetCharacterUseCase
import com.example.marvel.model.MarvelCharacter
import com.example.marvel.model.MarvelComic
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val getCharacterComicsUseCase: GetCharacterComicsUseCase
    ): ViewModel() {
    private val character = MutableLiveData<MarvelCharacter>()
    private val comics = MutableLiveData<List<MarvelComic>>()

    fun getCharacter(): LiveData<MarvelCharacter>{
        return character
    }

    fun getComics(): LiveData<List<MarvelComic>>{
        return comics
    }

    fun loadCharacter(id: Int){
        viewModelScope.launch {
            character.postValue(getCharacterUseCase.invoke(id))
        }
        loadComics(id)
    }

    fun loadComics(id: Int){
        viewModelScope.launch {
            comics.postValue(getCharacterComicsUseCase.invoke(id))
        }
    }
}