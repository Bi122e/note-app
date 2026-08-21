package com.example.noteapp.ui

 import android.os.Build
 import androidx.annotation.RequiresApi
 import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
 import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
 import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
 import com.example.noteapp.R
 import com.example.noteapp.extention.toDateTimeUi
 import com.example.noteapp.model.Note


@Composable
fun HomeScreen(
    notes: List<Note>
) {

    val items = listOf(1,2,3,4)
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier,
        topBar = { TopBar() },
        bottomBar = { BottomNoteBar() },
        containerColor = Color.Black
    ) { paddingValues ->


        Column(
            modifier = Modifier
                .padding(
                    paddingValues = PaddingValues(
                        vertical = paddingValues.calculateTopPadding(),
                        horizontal = 16.dp
                        )
                ),

        ) {

            SearchNoteBar(
                onQueryChange = { query = it},
                query = query,
                active = active,
                onActiveChange = {  }
            )

            if (notes.isNotEmpty()) {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = paddingValues,
                    verticalArrangement = Arrangement.spacedBy(0.dp),
                    horizontalArrangement = Arrangement.spacedBy(0.dp)
                ) {

                    items(notes) { noteItem ->

                        NoteItem(
                            note = noteItem
                        )

                    }
                }
            } else {

                EmptyScreen()

            }
        }

    }
}


@Composable
fun EmptyScreen() {

    Spacer(Modifier.height(40.dp))
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = "Chua co ghi chu nao",
            fontSize = 28.sp,
            color = Color.White
        )

        Image(
            painter = painterResource(R.drawable.ic_empty_note),
            contentDescription = null,
            modifier = Modifier
        )
    }

}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteItem(
    note: Note
) {

    Box(
        modifier = Modifier
            .width(250.dp)
            .heightIn(min = 150.dp, max = 200.dp)
            .padding(10.dp)
            .background(
                Color(0xFF616161),
                RoundedCornerShape(12.dp)
                )
            .padding(
                vertical = 24.dp,
                horizontal = 10.dp
            )
    ) {

       Column(
           verticalArrangement = Arrangement.spacedBy(6.dp),

       ) {

           Text(
               text = note.title,
               color = Color.White,
               fontSize = 16.sp,
               maxLines = 1,
               overflow = TextOverflow.Ellipsis
           )

            Text(
               text = note.content,
               color = Color(0xFFCFCFCF),
               fontSize = 16.sp,
               maxLines = 1,
               overflow = TextOverflow.Ellipsis
           )

           Spacer(Modifier.height(16.dp))

           Text(
               text = note.updatedAt?.toDateTimeUi() ?: "null",
               color = Color(0xFFDBDBDB),
               fontSize = 12.sp
           )
       }

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
        notes = listOf(
            Note()
        )
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





@Composable
fun BottomNoteBar() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 32.dp,
                horizontal = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {


        Box(
            modifier = Modifier
                .size(60.dp)
                .background(
                    color = Color(0xFFFFBF00),
                    CircleShape
                )
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.Rounded.Add,
                tint = Color.White,
                contentDescription = null
            )
        }

    }
}