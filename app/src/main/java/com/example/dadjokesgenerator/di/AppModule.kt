package com.example.dadjokesgenerator.di

import com.example.dadjokesgenerator.network.createHttpClient
import com.example.dadjokesgenerator.screen.main.JokesClient
import com.example.dadjokesgenerator.screen.main.MainScreenViewModel
import com.example.dadjokesgenerator.network.createJson
import com.example.dadjokesgenerator.screen.main.repository.JokesRepository
import com.example.dadjokesgenerator.screen.main.repository.JokesRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val appModule = module {
    single { createJson() }
    single { createHttpClient() }
    single { JokesClient(client = get(), json = get()) }
    single<JokesRepository> { JokesRepositoryImpl() }
    viewModel { MainScreenViewModel() }
}

fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    stopKoin()
    startKoin {
        appDeclaration()
        modules(
            appModule
        )
    }
}
