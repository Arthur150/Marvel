package com.example.marvel.data.datasource

import org.koin.dsl.module

object DataSourceModules {
    private val dataSourceModule = module {
        single<CharacterRemoteDataSource> {
            CharacterRemoteDataSourceImpl(get())
        }
    }

    val all = arrayOf(dataSourceModule)
}