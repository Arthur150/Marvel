package com.example.marvel

import android.app.Application
import com.example.marvel.data.datasource.DataSourceModules
import com.example.marvel.data.networking.NetworkingModules
import com.example.marvel.data.repository.RepositoryModules
import com.example.marvel.domain.DomainModules
import com.example.marvel.ui.UIModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarvelApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MarvelApplication)
            modules(
                *UIModules.all,
                *DomainModules.all,
                *RepositoryModules.all,
                *DataSourceModules.all,
                *NetworkingModules.all
            )
        }
    }
}