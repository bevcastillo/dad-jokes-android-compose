package com.example.dadjokesgenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dadjokesgenerator.di.initKoin
import com.example.dadjokesgenerator.screen.main.MainScreen
import com.example.dadjokesgenerator.screen.main.MainScreenContent
import com.example.dadjokesgenerator.ui.theme.DadJokesGeneratorTheme
import org.koin.core.component.KoinComponent

class MainActivity : ComponentActivity(), KoinComponent {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initKoin()
        setContent {
            DadJokesGeneratorTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreenContent()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    DadJokesGeneratorTheme {
        MainScreen(joke = "Hello", onNextClicked = {})
    }
}
