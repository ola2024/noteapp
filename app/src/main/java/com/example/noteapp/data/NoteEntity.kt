package com.example.noteapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.UUID


@Entity(tableName = "note_table")
data class NoteEntity(
    @PrimaryKey(autoGenerate = false)
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "title_info")
    val title: String,
    @ColumnInfo(name = "comment_info")
    val comment: String,
    @ColumnInfo(name = "entryDate_info")
    val entryDate: LocalDateTime = LocalDateTime.now()

)