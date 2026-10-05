package com.example.mipokedex_murrietajackt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mipokedex_murrietajackt.ui.theme.MiPokedex_MurrietaJackTTheme
import screens.MenuPokedexScreen

class PokedexList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiPokedex_MurrietaJackTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MenuPokedexScreen(innerPadding = innerPadding)
                }
            }
        }
    }
}
