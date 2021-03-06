package com.example.marvel.data.networking

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object NetworkingModulesTest {
    private val mockServer = module {
        single {
            MockWebServer()
        }
    }

    private val okHttpClientModule = module {
        single {
            OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.SECONDS)
                .addInterceptor(MarvelInterceptor())
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        }
    }

    private val retrofitModule = module {
        single {
            Retrofit.Builder()
                .baseUrl(get<MockWebServer>().url("/"))
                .client(get())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }

    private val servicesModule = module {
        factory {
            this.get<Retrofit>().create<CharacterService>()
        }
    }

    val all = arrayOf(okHttpClientModule, retrofitModule, servicesModule, mockServer)
}