package com.example.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [Items::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateNoteTypeConverter::class, UUIDNoteTypeConverter::class)
abstract class NoteDataBase : RoomDatabase() {
    abstract val noteDao: NoteDao
}