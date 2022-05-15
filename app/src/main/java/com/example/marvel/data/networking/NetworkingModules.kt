package com.example.marvel.data.networking

import com.example.marvel.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NetworkingModules {

    private val okhttpClientModule = module {
        single {
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(MarvelInterceptor())
                .build()
        }
    }

    private val retrofitModule = module {
        single {
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .client(get())
                .build()
        }
    }

    private val serviceModule = module {
        factory {
            this.get<Retrofit>().create<CharacterService>()
        }
    }

    val all = arrayOf(okhttpClientModule, retrofitModule, serviceModule)
}