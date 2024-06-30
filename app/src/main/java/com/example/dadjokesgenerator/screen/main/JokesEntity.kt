package com.example.dadjokesgenerator.screen.main

import kotlinx.serialization.Serializable

@Serializable
data class JokesEntity(
    val id: String,
    val joke: String,
    val status: Int
)
