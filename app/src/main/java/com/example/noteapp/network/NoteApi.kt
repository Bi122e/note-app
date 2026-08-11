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

    @GET("notes")
    suspend fun getNoteById(
        @Path("id") id: Long
    )
    //java
    //@GetMapping("/{id}")
    //public Note getNoteById(@PathVariable Long id) {
    //    return service.getById(id);
    //}

    //public Note getById(Long id) {
    //    return repository.findById(id)
    //            .orElseThrow(() -> new RuntimeException("Note not found"));
    //}
}