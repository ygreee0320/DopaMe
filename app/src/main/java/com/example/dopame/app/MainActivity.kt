package com.example.dopame.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.dopame.core.designsystem.DopaMeTheme
import com.example.dopame.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DopaMeTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = DopaMeTheme.colors.gray10
                ) {
                    HomeScreen()
                }
            }
        }
    }
}