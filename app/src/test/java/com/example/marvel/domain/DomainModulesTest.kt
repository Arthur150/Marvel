package com.example.marvel.domain

import com.example.marvel.data.datasource.DataSourceModules
import com.example.marvel.data.networking.NetworkingModules
import com.example.marvel.data.paging.PagingModules
import com.example.marvel.data.repository.RepositoryModules

object DomainModulesTest {
    val all = arrayOf(
        *DomainModules.all,
        *RepositoryModules.all,
        *PagingModules.all,
        *DataSourceModules.all,
        *NetworkingModules.all
    )
}