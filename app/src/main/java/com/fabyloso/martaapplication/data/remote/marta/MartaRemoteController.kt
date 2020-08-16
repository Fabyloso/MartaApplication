package com.fabyloso.martaapplication.data.remote.marta

import com.fabyloso.martaapplication.BuildConfig
import com.fabyloso.martaapplication.data.remote.BaseRemoteController
import okhttp3.Interceptor

class MartaRemoteController : BaseRemoteController() {
    override val baseUrl: String
        get() = "http://developer.itsmarta.com/"
    override val authInterceptor: Interceptor
        get() = Interceptor { chain ->
            val urlBuilder = chain.request().url().newBuilder().apply {
                addQueryParameter("apikey", BuildConfig.MARTA_KEY)
            }
            val newRequest = chain.request()
                .newBuilder()
                .url(urlBuilder.build())
                .build()

            chain.proceed(newRequest)
        }
}