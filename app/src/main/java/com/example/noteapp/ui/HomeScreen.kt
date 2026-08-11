package com.example.noteapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Note
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen() {

    val items = listOf(1,2,3,4)

    Scaffold(
        modifier = Modifier,
        topBar = { TopBar() },
        containerColor = Color.Black
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = paddingValues
        ) {

            if (items.isNotEmpty()) {
                items(items) { note ->
                 }
            } else {

                item {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            imageVector = Icons.Default.Note,
                            contentDescription = null,
                            tint = Color.Yellow.copy(0.5f),
                            modifier = Modifier.size(50.dp)
                        )

                        Text(
                            text = "Chua co ghi chu nao",
                            color = Color.White,

                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview (showBackground = true)
fun PreviewHomeScreen() {

    Box(Modifier.fillMaxSize())
    HomeScreen(

    )
}


@Composable
fun TopBar() {

}