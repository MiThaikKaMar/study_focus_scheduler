package com.studyfocusscheduler.app.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminder")
data class ReminderVO(
    @PrimaryKey(autoGenerate = true)
    var reminderId: Int = 0,
    val noteId: Int, // Foreign key referencing the note table
    val datetime: Long
)