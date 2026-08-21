package com.example.noteapp.model

import java.time.LocalDateTime

data class Note(
    val id: Long = 0,
    val title: String = "",
    val content: String = "",

    val createdAt: String? = null,
    val updatedAt: String? = null,
)
