package com.example.marvel.ui

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object UIModules {
        private val characterListModule = module {
            viewModel {
                CharacterListViewmodel(get())
            }
        }

        val all = arrayOf(characterListModule)
}