package com.fabyloso.martaapplication.data.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


abstract class BaseRemoteController {
    abstract val baseUrl: String
    abstract val authInterceptor: Interceptor

    private val baseClient
        get() = OkHttpClient().newBuilder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(authInterceptor)
            .build()


    val retrofit: Retrofit
        get() {
            return Retrofit.Builder()
                .client(baseClient)
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }
}