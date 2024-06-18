package com.example.noteapp.common

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    text: String,
    enable: Boolean,
    modifier: Modifier = Modifier,
    labelId: String,
    isSingle: Boolean,
    isError: Boolean,
    maxLine: Int = 1,
    readOnly: Boolean,
    colors: TextFieldColors,
    onTextChange: (String) -> Unit
) {
    TextField(
        value = text,
        modifier = modifier,
        onValueChange = onTextChange,
        enabled = enable,
        label = { Text(text = labelId) },
        maxLines = maxLine,
        readOnly = readOnly,
        singleLine = isSingle,
        isError = isError,
        colors = colors
    )

}

