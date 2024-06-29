package com.example.dadjokesgenerator.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MainScreenContent() {
    // TODO
}

@Composable
fun MainScreen() {
    Column(modifier = Modifier.fillMaxSize().background(Color.Blue), verticalArrangement = Arrangement.Center) {
        Text(
            text = "Can I watch the TV? Dad: Yes, but don’t turn it on.",
            modifier = Modifier.padding(38.dp),
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}
