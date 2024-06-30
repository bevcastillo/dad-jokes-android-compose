package com.example.dadjokesgenerator.network

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@OptIn(ExperimentalSerializationApi::class)
internal fun createJson(): Json {
    return Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        explicitNulls = false
    }
}
