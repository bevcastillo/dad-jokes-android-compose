package com.example.dadjokesgenerator.screen.main

sealed interface MainScreenEvent {
    data object OnNextClicked : MainScreenEvent
}
