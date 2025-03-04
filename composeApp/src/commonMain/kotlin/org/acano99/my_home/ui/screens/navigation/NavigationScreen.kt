package org.acano99.my_home.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.acano99.my_home.ui.screens.day.DayScreen
import org.acano99.my_home.ui.screens.home.HomeScreen

@Composable
fun NavigationScreen() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = "home") {
        composable(route = "home") {
            HomeScreen(navController = navHostController)
        }
        composable(route = "day") {
            DayScreen()
        }
    }
}