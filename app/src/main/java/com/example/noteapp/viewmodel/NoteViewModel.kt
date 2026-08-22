package com.example.noteapp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.model.Note
import com.example.noteapp.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NoteViewModel: ViewModel() {


    val notes =  MutableStateFlow<List<Note>>(emptyList())
    val note  = MutableStateFlow<Note?>(null)

    init {
        loadNotes()
    }

    private fun loadNotes() {
        viewModelScope.launch {
            notes.value = RetrofitInstance.api.getNotes()
        }
    }

    fun add(title: String, content: String) {

        viewModelScope.launch {


            try {
                RetrofitInstance.api.create(
                    Note(
                        title = title,
                        content = content
                    )
                )
                notes.value = RetrofitInstance.api.getNotes()
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("error_add", e.toString())
            }
         }
    }

    fun delete(id: Long) {

        viewModelScope.launch {

            RetrofitInstance.api.delete(id)

            loadNotes()
        }
    }

    fun getNote(noteId: Long) {
        viewModelScope.launch {
            val apiNote = RetrofitInstance.api.getNoteById(noteId)
            note.value = apiNote
        }
    }
}