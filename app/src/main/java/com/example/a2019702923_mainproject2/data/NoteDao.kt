package com.example.a2019702923_mainproject2.data
/*
Bokang Ntovana
2019702923
* */
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

//Data Access Object file, where we can run database operations, like DML,DDL and queries on our data
@Dao
interface NoteDao {

    @Upsert
    suspend fun upsertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note ORDER BY dateAdded")
    fun getNotesOrderedByDateAdded(): Flow<List<Note>>


    @Query("SELECT * FROM note ORDER BY title ASC")
    fun getNotesOrderedByTitle(): Flow<List<Note>>

}