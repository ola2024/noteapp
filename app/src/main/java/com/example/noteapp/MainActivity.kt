package com.example.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteapp.screen.NoteScreen
import com.example.noteapp.screen.NoteViewModel
import com.example.noteapp.ui.theme.NoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val noteViewModel:NoteViewModel by viewModels()
            MyApp {
                MainContent(noteViewModel)
            }
        }
    }
}

@Composable
fun MainContent(noteViewModel: NoteViewModel = viewModel()) {
    val loadAllLists = noteViewModel.addAllNote()
    NoteScreen(
        itemList = loadAllLists,
        onDelete = {noteViewModel.deleteNote(it)},
        onAdd = { noteViewModel.addNote(it)})
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