package com.fabyloso.martaapplication.data.remote

import retrofit2.Response
import timber.log.Timber

abstract class BaseRemoteSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): NetworkResult<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return NetworkResult.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): NetworkResult<T> {
        Timber.d(message)
        return NetworkResult.error("Network call has failed for a following reason: $message")
    }

}