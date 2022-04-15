package com.example.marvel.domain

import org.koin.dsl.module

object DomainModules {
    private val useCaseModule = module {
        factory {
            GetAllCharacterUseCase(get())
        }
    }

    val all = arrayOf(useCaseModule)
}