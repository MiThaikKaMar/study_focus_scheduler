package com.studyfocusscheduler.app.data.vos

import androidx.room.Embedded
import androidx.room.Relation

data class NoteWithReminderVO(
    @Embedded val note: NoteVO,
    @Relation(
        parentColumn = "noteId",
        entityColumn = "noteId"
    )
    val reminder: ReminderVO?
)
