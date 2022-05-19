package com.example.marvel.ui

import com.example.marvel.ui.characterDetail.CharacterDetailViewModel
import com.example.marvel.ui.characterList.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object UIModules {
    private val module = module {
        viewModel {
            CharacterListViewModel(get())
        }
        viewModel {
            CharacterDetailViewModel(get(),get())
        }
    }

    val all = arrayOf(module)
}