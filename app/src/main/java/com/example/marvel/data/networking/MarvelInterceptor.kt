package com.example.marvel.data.networking

import com.example.marvel.BuildConfig
import com.example.marvel.domain.GetHashMd5UseCase
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class MarvelInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        val getHashMd5UseCase = GetHashMd5UseCase()

        val ts = Date().toString()
        val publicKey = BuildConfig.API_KEY_PUBLIC
        val privateKey = BuildConfig.API_KEY_PRIVATE
        var hash: String?

        runBlocking {
            val result = getHashMd5UseCase(ts + privateKey + publicKey)
            hash = result.getOrThrow()
        }

        requestBuilder.url(
            chain.request().url.newBuilder()
                .addQueryParameter("ts", ts)
                .addQueryParameter("apikey", publicKey)
                .addQueryParameter("hash", hash)
                .toString()
        )

        return chain.proceed(requestBuilder.build())
    }
}