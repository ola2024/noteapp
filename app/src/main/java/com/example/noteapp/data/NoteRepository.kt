package com.example.noteapp.data

import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun insertNote(note: Items)
    suspend fun deleteNote(note: Items)
    suspend fun getNoteById(id: String)
    suspend fun updateNote(note: Items)
    suspend fun deleteAllNote()
    fun getAllNotes(): Flow<List<Items>>
}