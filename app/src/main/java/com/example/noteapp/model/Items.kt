package com.example.noteapp.model

import java.time.LocalDateTime
import java.util.UUID

data class Items(
    val Id: UUID = UUID.randomUUID(),
    val title: String,
    val comment: String,
    val entryDate:LocalDateTime = LocalDateTime.now()
)

fun dummyDate() = listOf(
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    ),
    Items(
        title = "I am back",
        comment = "Can we go out of the house"
    )
)