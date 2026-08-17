package com.example.noteapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen() {

    val items = listOf(1,2,3,4)
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier,
        topBar = { TopBar() },
        containerColor = Color.Black
    ) { paddingValues ->


        Column(
            modifier = Modifier
                .padding(paddingValues),

        ) {

            SearchNoteBar(
                onQueryChange = { query = it},
                query = query,
                active = active,
                onActiveChange = {  }
            )
        }
        if (items.isNotEmpty()) {

            LazyColumn(contentPadding = paddingValues, ) {

                items(items) { item ->


                }
            }
        } else {

        }
    }
}

@Composable
fun NoteItem() {

    Box(
        modifier = Modifier
            .width(250.dp)
            .padding(10.dp)
    ) {

    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchNoteBar(
    onQueryChange: ( String ) -> Unit,
    query: String,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        SearchBar(
            inputField = {
                SearchBarDefaults.InputField(
                    colors = (
                            SearchBarDefaults.inputFieldColors(
                                unfocusedContainerColor = Color.LightGray,
                                focusedContainerColor = Color.LightGray
                            )
                    ),
                    query = query,
                    onQueryChange = { onQueryChange(it) },
                    onSearch = {},
                    expanded = active,
                    onExpandedChange = {},
                    placeholder = {
                        Text(
                            text = "Tim kiem"
                        )
                    }
                )
            },
            expanded = active,
            onExpandedChange = {},
            colors = SearchBarDefaults.colors(
                containerColor = Color.Black
            )

        ) {

        }
    }
}
@Composable
@Preview (showBackground = true)
fun PreviewHomeScreen() {

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    )
    HomeScreen(

    )
}


@Composable
fun TopBar() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = "Ghi Chu",
            color = Color.White,
            fontSize = 14.sp,
        )
    }
}


data class Note(
    val id: Long = 0,
    val title: String = "",
    val content: String = "",

    )
