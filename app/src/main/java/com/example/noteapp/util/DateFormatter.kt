package com.example.noteapp.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
fun convertDateToLong(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("HH:mm:ss.SSSZ")
    return format.format(date)
}