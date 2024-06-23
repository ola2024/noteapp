package com.example.noteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// This interface contains function that query the SQLite
@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Items)

    @Delete
    suspend fun deleteNote(note: Items)

    @Query(value = "SELECT * FROM note_table")
    fun getAllNotes(): Flow<List<Items>>

    @Query(value = "SELECT * FROM note_table WHERE id = :id")
    suspend fun getNoteById(id: String): Items

    @Update(onConflict = OnConflictStrategy.ABORT)
    suspend fun updateNote(note: Items)

    @Query("DELETE FROM note_table")
    suspend fun deleteAllNote()

}
