package com.example.a2019702923_mainproject2.presentation
/*
Bokang Ntovana
2019702923
* */
import com.example.a2019702923_mainproject2.data.Note
//To define note UI events
sealed interface NotesEvent {
    object SortNotes: NotesEvent

    data class DeleteNote(val note: Note): NotesEvent

    data class SaveNote(
        val title: String,
        val description: String
    ): NotesEvent
}