package com.example.netflixClone.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.netflixClone.ui.main.MainView

@Composable
fun MainNavigation(statusBarHeight: MutableState<Int>) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainView(statusBarHeight = statusBarHeight) }
        // TODO: Add more destinations
    }
}
