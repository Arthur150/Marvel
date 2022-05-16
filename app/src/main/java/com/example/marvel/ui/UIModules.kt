package com.example.marvel.ui

import com.example.marvel.ui.characterList.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object UIModules {
    private val characterListModule = module {
        viewModel {
            CharacterListViewModel(get())
        }
    }

    val all = arrayOf(characterListModule)
}