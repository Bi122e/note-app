package com.example.noteapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteapp.ui.DetailScreen
import com.example.noteapp.ui.HomeScreen
import com.example.noteapp.viewmodel.NoteViewModel


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

            val noteViewModel: NoteViewModel = viewModel()
            val notes = noteViewModel.notes

            HomeScreen(notes)
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