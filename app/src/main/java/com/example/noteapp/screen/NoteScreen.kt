package com.example.noteapp.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.R
import com.example.noteapp.common.InputTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen() {
    val expanded = remember {
        mutableStateOf(false)
    }
    val title = remember {
        mutableStateOf("")
    }
    val addNote = remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(6.dp)) {

        TopAppBar(
            title = {
                Text(
                    modifier = Modifier,
                    text = stringResource(id = R.string.app_name),
                    style = TextStyle(fontStyle = FontStyle.Normal),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif
                )
            }, actions = {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Information",
                        modifier = Modifier.clickable { expanded.value = !expanded.value }
                    )
                    AnimatedVisibility(visible = expanded.value) {
                        Text(text = "This App is a Note App")
                    }
                }
            }
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            InputTextField(
                text = title.value,
                enable = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp),
                labelId = stringResource(id = R.string.title),
                isSingle = true,
                isError = false,
                readOnly = false,
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent)
            ) { title.value = it }
            InputTextField(
                text = addNote.value,
                enable = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp),
                labelId = stringResource(id = R.string.add_note),
                isSingle = true,
                isError = false,
                readOnly = false,
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent)
            ) { addNote.value = it }

            Button(
                onClick = {

                },
                modifier = Modifier.padding(top = 20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                Text(text = stringResource(id = R.string.save))
            }
        }
    }
}

@Preview
@Composable
fun PreviewCompose() {
    NoteScreen()
}