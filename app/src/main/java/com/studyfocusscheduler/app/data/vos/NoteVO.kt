package com.studyfocusscheduler.app.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note")
data class NoteVO(
    @PrimaryKey(autoGenerate = true)
    val noteId: Int = 0,
    val title: String,
    val content: String,
    val timestamp: Long,
    val folderId: Int // Foreign key referencing the folder table
) : Serializable