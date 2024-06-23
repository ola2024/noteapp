package com.example.noteapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID


@Entity(tableName = "note_table")
data class Items(
    @PrimaryKey(autoGenerate = false)
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "title_info")
    val title: String,
    @ColumnInfo(name = "comment_info")
    val comment: String,
    @ColumnInfo(name = "entryDate_info")
    val entryDate: Date = Date.from(Instant.now())
)
//We need to convert this two type "Date"  and "UUID" to something room
// can understand and save verse versal into Db.