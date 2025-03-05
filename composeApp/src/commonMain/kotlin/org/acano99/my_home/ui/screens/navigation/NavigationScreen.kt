package org.acano99.my_home.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.acano99.my_home.ui.screens.day.DayScreen
import org.acano99.my_home.ui.screens.food.addFood.AddFoodHome
import org.acano99.my_home.ui.screens.food.foodHome.FoodHomeScreen

@Composable
fun NavigationScreen() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = "foodHome") {
        composable(route = "foodHome") {
            FoodHomeScreen(navController = navHostController)
        }
        composable(route = "addFood") {
            AddFoodHome()
        }
        composable(route = "day") {
            DayScreen()
        }
    }
}