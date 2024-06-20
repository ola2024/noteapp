package com.example.noteapp.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.noteapp.model.Items
import com.example.noteapp.model.dummyDate

class NoteViewModel : ViewModel() {
    private val noteLists = mutableStateListOf<Items>()

    init {
        noteLists.addAll(dummyDate())
    }

    fun addNote(note: Items) {
        noteLists.add(note)
    }

    fun deleteNote(note: Items) {
        noteLists.remove(note)
    }

    fun addAllNote(): List<Items> {
        return noteLists
    }
}