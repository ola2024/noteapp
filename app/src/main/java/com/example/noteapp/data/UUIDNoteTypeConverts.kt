package com.example.noteapp.data

import androidx.room.TypeConverter

import java.util.UUID

class UUIDNoteTypeConverter {
    @TypeConverter
    fun stringFromUUID(uuid: UUID): String {
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(string: String): UUID {
        return UUID.fromString(string)
    }
}