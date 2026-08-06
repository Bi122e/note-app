package com.example.noteapp.ui.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun NoteScreen(
     vm: NoteViewModel = viewModel()
) {

    LazyColumn() {

        items(vm.notes) { note ->

            Text(note.title)
        }
    }

}