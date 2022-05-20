package com.example.marvel.data.repository

import com.example.marvel.data.datasource.DataSourceModules
import com.example.marvel.data.networking.NetworkingModules
import com.example.marvel.data.paging.PagingModules

object RepositoryModulesTest {
    val all = arrayOf(
        *RepositoryModules.all,
        *PagingModules.all,
        *DataSourceModules.all,
        *NetworkingModules.all
    )
}