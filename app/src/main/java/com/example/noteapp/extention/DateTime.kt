package com.example.noteapp.extention

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun String.toDateTimeUi(): String {
    val dateTime = LocalDateTime.parse(this)

    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")

    return dateTime.format(formatter)
}