package com.example.dadjokesgenerator.screen.main

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class JokesClient(private val client: HttpClient, private val json: Json) {
    suspend fun getJoke(): JokesEntity {
        val response = client.get("https://icanhazdadjoke.com/")
        return json.decodeFromString(JokesEntity.serializer(), response.bodyAsText())
    }
}
