package com.example.conversordemoedaparaviagem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.conversordemoedaparaviagem.ui.theme.ConversorDeMoedaParaViagemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConversorDeMoedaParaViagemTheme {
                AppNavigation()
            }
        }
    }
}