package com.example.noteapp.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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


@RequiresApi(Build.VERSION_CODES.O)
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
            val notes by noteViewModel.notes.collectAsState()

             HomeScreen(
                notes = notes,
                onAddNote = {
                    navController.navigate("detail")
                },
                onNavigationDetail = { noteId ->

                    navController.navigate("detail/{$noteId}")
                }
            )
        }

        composable(
            route = "detail"
        ) {
            DetailScreen(
                note = null
            )
        }


        composable(
            route = "detail/{noteId}",
            arguments = listOf(
                navArgument("noteId") {
                    type = NavType.LongType
                }
            )
        ) { navBackStack ->

            val noteId = navBackStack.arguments?.getLong("noteId") ?: return@composable

            val viewModel: NoteViewModel = viewModel()

            LaunchedEffect(noteId) {
                viewModel.getNote(noteId)
            }

            val note by viewModel.note.collectAsState()


            DetailScreen(
                note = note
            )
        }
    }
}