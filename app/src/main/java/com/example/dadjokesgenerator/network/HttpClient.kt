package com.example.dadjokesgenerator.network

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders

private const val TIME_OUT = 60_000
private val httpClient = HttpClient(Android) {
    install(ContentNegotiation) {
        engine {
            connectTimeout = TIME_OUT
            socketTimeout = TIME_OUT
        }
    }
//    install(ContentNegotiation) {
//        createJson()
//    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.v("Logger Ktor =>", message)
            }
        }
        level = LogLevel.ALL
    }

    install(ResponseObserver) {
        onResponse { response ->
            Log.d("HTTP status:", "${response.status.value}")
        }
    }

    defaultRequest {
        header("Accept", "application/json")
    }
}

internal fun createHttpClient() : HttpClient {
    return httpClient
}
