package com.example.a2019702923_mainproject2.data
/*
Bokang Ntovana
2019702923
* */
import androidx.room.Entity
import androidx.room.PrimaryKey

//The entity we store in our database
@Entity
data class Note(

    val title: String,
    val description: String,
    val dateAdded: Long,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)