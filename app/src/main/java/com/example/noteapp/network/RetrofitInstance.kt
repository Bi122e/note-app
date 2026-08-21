package com.example.noteapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

//    private const val BASE_URL = "http://10.0.2.2:8080/"
    //neu dung dt - pc that thi dung dia chi ip: 192.168...8080

    private const val BASE_URL = "http://192.168.1.123:8080/"

    val api: NoteApi by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NoteApi::class.java)
    }
 }