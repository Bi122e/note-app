package com.example.noteapp.ui

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
 import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
 import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
 import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DetailScreen() {


    Scaffold(
        modifier = Modifier
            .padding(
                vertical = 10.dp,
                horizontal = 16.dp
            ),
        containerColor = Color.Black,
        topBar = {
            TopBarDetail()
        }
    ) { paddingValues ->


        Column(
            modifier = Modifier
                .padding(vertical = paddingValues.calculateBottomPadding() + 10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {

            TextHeader()

            DateHeader()

            Spacer(Modifier.height(15.dp))

            TextContent()
        }

    }

}


@Composable
fun TextContent() {

    val text = listOf("sdfsdf")

    LazyColumn() {

        item {

            Text(
                text = text.toString(),
                color = Color.White
            )
        }
    }
}

@Composable
fun TextHeader() {
    Text(
        text = "Test",
        color = Color.White,
        fontSize = 32.sp
    )
}

@Composable
fun DateHeader() {

    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        Text(
            text = "7 thang 2 11:30",
            color = Color.LightGray,
            fontSize = 12.sp
        )

        Spacer(Modifier.width(6.dp))

        Text(
            text = "32 Ky tu",
            color = Color.LightGray,
            fontSize = 12.sp
        )
    }


}

@Composable
fun TopBarDetail() {

    Row(
        modifier = Modifier.padding(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {


        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(32.dp)
        )


        Spacer(Modifier.weight(1f))


        Icon(
            imageVector = Icons.Rounded.Check,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(32.dp)
        )
    }
}