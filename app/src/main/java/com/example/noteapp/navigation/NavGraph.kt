package com.example.noteapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteapp.ui.DetailScreen
import com.example.noteapp.ui.HomeScreen


@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController,
        "home"
    ) {

        composable(
            route = "home"
        ) {
            HomeScreen()
        }


        composable(
            route = "detail/{noteId}",
            arguments = listOf(
                navArgument("noteId") {
                    type = NavType.LongType
                }
            )
        ) {  navBackStack ->

            val noteId = navBackStack.arguments?.getLong("noteId") ?: return@composable

            DetailScreen()
        }
    }
}