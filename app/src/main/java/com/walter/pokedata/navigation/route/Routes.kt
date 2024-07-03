package com.walter.pokedata.navigation.route

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.walter.pokedata.home.presentation.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object Home {
    val route = "home"
}

@Composable
fun MainNavController() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home.route) {
        composable(Home.route) {
            HomeScreen()
        }
    }
}

