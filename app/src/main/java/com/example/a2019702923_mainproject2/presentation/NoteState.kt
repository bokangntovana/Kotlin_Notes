package com.example.a2019702923_mainproject2.presentation
/*
Bokang Ntovana
2019702923
* */
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.a2019702923_mainproject2.data.Note
//Handles state of the note
data class NoteState(
    val notes: List<Note> = emptyList(),
    val title: MutableState<String> = mutableStateOf(""),
    val description: MutableState<String> = mutableStateOf("")
)