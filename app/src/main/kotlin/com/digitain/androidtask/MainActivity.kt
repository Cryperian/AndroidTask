package com.digitain.androidtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.digitain.core.ui.designsystem.AppTheme
import com.digitain.feature.jackpot.ui.JACKPOT_SCREEN
import com.digitain.feature.jackpot.ui.JackpotScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Container()
            }
        }
    }
}

@Composable
fun Container(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = JACKPOT_SCREEN,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(JACKPOT_SCREEN) {
                JackpotScreen()
            }
        }
    }
}

