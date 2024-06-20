package com.example.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class NoteDataBase : RoomDatabase() {
    abstract val noteDao: NoteDao


}