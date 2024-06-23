package com.example.noteapp.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.Items
import com.example.noteapp.data.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    //private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _noteList = MutableStateFlow<List<Items>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch {
            noteRepository.getAllNotes().distinctUntilChanged().collect { item ->
                if (item.isEmpty()) {
                    Log.d("Empty", ": Empty list ")
                } else {
                    _noteList.value = item
                }
            }
        }
    }

    fun addNote(note: Items) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.insertNote(note)

    }

    fun deleteNote(note: Items) =
        viewModelScope.launch(Dispatchers.IO) { noteRepository.deleteNote(note) }

    fun getNoteById(id: String) =
        viewModelScope.launch(Dispatchers.IO) { noteRepository.getNoteById(id) }

    fun updateNote(note: Items) =
        viewModelScope.launch(Dispatchers.IO) { noteRepository.updateNote(note) }

    fun deleteAllNote() = viewModelScope.launch(Dispatchers.IO) { noteRepository.deleteAllNote() }

//    fun addAllNote(): List<Items> {
//        return _noteList.value
//    }
/*companion object {

    val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras
        ): T {
            // Get the Application object from extras
            val application = checkNotNull(extras[APPLICATION_KEY])
            // Create a SavedStateHandle for this ViewModel from extras
            val savedStateHandle = extras.createSavedStateHandle()

            return NoteViewModel(
                (application as MyApplication).myRepository,
                savedStateHandle
            ) as T
        }
    }
}*/

}