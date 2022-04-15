package com.example.marvel.koin

import org.koin.dsl.module

object KoinModules {
    private val koinModule = module {
        single {

        }
        factory {

        }
    }

    val all = arrayOf(koinModule)
}