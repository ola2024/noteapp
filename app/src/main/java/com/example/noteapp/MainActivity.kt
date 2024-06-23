package com.example.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteapp.screen.NoteScreen
import com.example.noteapp.screen.NoteViewModel
import com.example.noteapp.ui.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyApp {

                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    val noteViewModel:NoteViewModel = viewModel()
    val loadAllLists = noteViewModel.noteList.collectAsState().value
    NoteScreen(
        itemList = loadAllLists,
        onDelete = { noteViewModel.deleteNote(it) },
        onAdd = { noteViewModel.addNote(it) })
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    NoteAppTheme {
        content()
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppTheme {
        MyApp {

        }
    }
}