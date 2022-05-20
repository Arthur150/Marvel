package com.example.marvel.data.datasource

import com.example.marvel.data.networking.NetworkingModules
import com.example.marvel.data.paging.PagingModules

object DataSourceModulesTest {
    val all = arrayOf(*PagingModules.all, *DataSourceModules.all, *NetworkingModules.all)
}