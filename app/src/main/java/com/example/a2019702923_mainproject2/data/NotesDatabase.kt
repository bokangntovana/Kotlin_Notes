package com.example.a2019702923_mainproject2.data
/*
Bokang Ntovana
2019702923
* */
import androidx.room.Database
import androidx.room.RoomDatabase
//Room Database declaration
@Database(
    entities = [Note::class],
    version = 1
)
abstract class NotesDatabase: RoomDatabase(){
    abstract val dao: NoteDao
}