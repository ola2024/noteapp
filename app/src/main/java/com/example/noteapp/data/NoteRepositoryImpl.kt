package com.example.noteapp.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {
    override suspend fun insertNote(note: Items) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Items) {
        noteDao.deleteNote(note)
    }

    override suspend fun getNoteById(id: String) {
        noteDao.getNoteById(id)
    }

    override suspend fun updateNote(note: Items) {
        noteDao.updateNote(note)
    }

    override suspend fun deleteAllNote() {
        noteDao.deleteAllNote()
    }

    override fun getAllNotes(): Flow<List<Items>> {
        return noteDao.getAllNotes()
    }
}