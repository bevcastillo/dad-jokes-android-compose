package com.example.dadjokesgenerator.screen.main.repository

import com.example.dadjokesgenerator.screen.main.JokesEntity

interface JokesRepository {
    suspend fun getJokes(): Result<JokesEntity>
}
