package com.example.numfun.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.numfun.ui.game.GameScreen
import com.example.numfun.ui.home.HomeScreen

object Routes {
    const val HOME = "home"
    const val GAME = "game"
}

@Composable
fun AppNavGraph(
    startDestination: String = Routes.HOME
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(Routes.HOME) {
            HomeScreen(
                onNewGame = {
                    navController.navigate(Routes.GAME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                },
                onResumeGame = {
                    navController.navigate(Routes.GAME)
                }
            )
        }

        composable(Routes.GAME) {
            GameScreen(
                onExit = {
                    navController.popBackStack()
                }
            )
        }
    }
}