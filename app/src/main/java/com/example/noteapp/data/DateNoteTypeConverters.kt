package com.example.noteapp.data

import androidx.room.TypeConverter
import java.util.Date

class DateNoteTypeConverter {
    @TypeConverter
    fun timeStampFromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun dateFromTimeStamp(timestamp: Long):Date{
        return Date(timestamp)
    }
}