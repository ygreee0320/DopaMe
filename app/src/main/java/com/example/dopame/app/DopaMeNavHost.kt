package com.example.dopame.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dopame.screens.HomeScreen
import com.example.dopame.screens.home.AddLinkScreen
import com.example.dopame.screens.mining.AddAnswerScreen
import com.example.dopame.screens.mining.MiningDoneScreen

@Composable
fun DopaMeNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
    ) {
        composable("home") { HomeScreen(navController) }
        composable("miningStep1") { AddLinkScreen(navController) }
        composable("miningStep2") { AddAnswerScreen(navController) }
        composable("miningDone") { MiningDoneScreen(navController) }
    }
}