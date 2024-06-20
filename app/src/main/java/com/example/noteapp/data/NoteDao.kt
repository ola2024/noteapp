package com.example.noteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.noteapp.model.Items


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: List<Items>)

    @Delete
    fun deleteNote(note: Items)

    //@Insert("SELECT * FROM note_table WHERE id = ")

}
