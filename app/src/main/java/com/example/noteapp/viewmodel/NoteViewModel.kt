package com.example.noteapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.model.Note
import com.example.noteapp.network.RetrofitInstance
import kotlinx.coroutines.launch

class NoteViewModel: ViewModel() {


    var notes by mutableStateOf<List<Note>>(emptyList())

    init {
        loadNotes()
    }

    private fun loadNotes() {
        viewModelScope.launch {
            notes = RetrofitInstance.api.getNotes()
        }
    }

    fun add(title: String, content: String) {

        viewModelScope.launch {

            RetrofitInstance.api.create(
                Note(
                    title = title,
                    content = content
                )
            )
        }

        loadNotes()
    }

    fun delete(id: Long) {

        viewModelScope.launch {

            RetrofitInstance.api.delete(id)

            loadNotes()
        }
    }
}