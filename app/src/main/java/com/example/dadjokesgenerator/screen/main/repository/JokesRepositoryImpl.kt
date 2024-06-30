package com.example.dadjokesgenerator.screen.main.repository

import com.example.dadjokesgenerator.screen.main.JokesClient
import com.example.dadjokesgenerator.screen.main.JokesEntity
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class JokesRepositoryImpl : JokesRepository, KoinComponent {
    private val client: JokesClient by inject()

    override suspend fun getJokes(): Result<JokesEntity> {
        return try {
            Result.success(client.getJoke())
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}
