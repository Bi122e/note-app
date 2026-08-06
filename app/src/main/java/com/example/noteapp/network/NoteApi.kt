package com.example.noteapp.network

import com.example.noteapp.model.Note
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NoteApi {

    @GET("notes")
    suspend fun getNotes(): List<Note>

    @POST("notes")
    suspend fun create(
        @Body note: Note
    ): Note

    @DELETE("notes")
    suspend fun delete(
        @Path("id") id: Long
    )
}