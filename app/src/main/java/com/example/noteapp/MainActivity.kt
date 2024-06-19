package com.example.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.noteapp.model.Items
import com.example.noteapp.model.dummyDate
import com.example.noteapp.screen.NoteScreen
import com.example.noteapp.ui.theme.NoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val addedNote = remember {
                mutableListOf<Items>()
            }
            MyApp {
                NoteScreen(itemList = addedNote, onDelete = {addedNote.remove(it)}, onAdd = {addedNote.add(it)})
            }
        }
    }
}
@Composable
fun MainContent(){

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