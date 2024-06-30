package com.example.dadjokesgenerator.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreenContent() {
    val viewModel: MainScreenViewModel = koinViewModel()
    val state = viewModel.state.collectAsState().value
    val onEvent = viewModel::onEvent
    state.joke?.let { MainScreen(joke = it) {
        onEvent(MainScreenEvent.OnNextClicked)
    }}
}

@Composable
fun MainScreen(joke: String, onNextClicked: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = joke,
            modifier = Modifier.padding(38.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 28.sp
        )

        Button(onClick = { onNextClicked.invoke() }) {
            Text(text = "Next")
        }
    }
}
