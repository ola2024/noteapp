package com.example.noteapp.screen

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.R
import com.example.noteapp.common.InputTextField
import com.example.noteapp.data.Items
import com.example.noteapp.util.convertDateToLong

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    itemList: List<Items>,
    onAdd: (Items) -> Unit,
    onDelete: (Items) -> Unit
) {
    val expanded = remember {
        mutableStateOf(false)
    }
    val title = remember {
        mutableStateOf("")
    }
    val addNote = remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Column(modifier = Modifier.padding(6.dp)) {

        TopAppBarComposable(expanded)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
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
            NoteButton(
                uiText = stringResource(id = R.string.save),
                onClick = {
                    //TODO Handle click event here
                    if (title.value.isNotEmpty() && addNote.value.isNotEmpty()) {
                        onAdd(Items(title = title.value, comment = addNote.value))
                        title.value = ""
                        addNote.value = ""
                        Toast.makeText(context, "Note Added", Toast.LENGTH_LONG).show()
                    }
                },
                enable = true
            )
            Divider(modifier = Modifier.fillMaxWidth(), thickness = 4.dp)
            LazyColumn(modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)) {
                items(items = itemList) { note ->
                    ContentRow(item = note) {
                        onDelete(note)
                    }
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopAppBarComposable(expanded: MutableState<Boolean>) {
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
}

@Composable
fun ContentRow(item: Items, onItemClick: (Items) -> Unit) {
    //TODO fixed delete bug also adding viewmodel later for state management.
    Card(
        modifier = Modifier
            .clickable { onItemClick(item) }
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        elevation = CardDefaults.cardElevation(pressedElevation = 1.dp),
        border = BorderStroke(width = 1.dp, color = Color.DarkGray.copy(alpha = 1f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, bottom = 6.dp, top = 6.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Color.DarkGray,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                ) {
                    append("Title: ")
                }
                withStyle(
                    SpanStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraLight,
                        fontFamily = FontFamily.Serif
                    )
                ) {
                    append(item.title)
                }
            }
            )

            Text(text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Color.DarkGray,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Serif
                    )
                ) {
                    append("Comment: ")
                }
                withStyle(
                    SpanStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraLight,
                        fontFamily = FontFamily.Serif
                    )
                ) {
                    append(item.comment)
                }
            }
            )
            Text(text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Color.DarkGray,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Serif
                    )
                ) {
                    append("Time: ")
                }
                withStyle(
                    SpanStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraLight,
                        fontFamily = FontFamily.Serif
                    )
                ) {
                    append(convertDateToLong(item.entryDate.time))
                }
            }
            )
        }
    }
}

@Composable
fun NoteButton(
    uiText: String,
    onClick: () -> Unit,
    enable: Boolean
) {
    Button(
        onClick = onClick,
        enabled = enable,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(Color.Red)
    ) {
        Text(uiText)
    }
}

@Preview
@Composable
fun PreviewCompose() {
    NoteScreen(onAdd = {}, onDelete = {}, itemList = emptyList())
}