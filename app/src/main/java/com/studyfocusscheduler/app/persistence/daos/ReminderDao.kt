package com.studyfocusscheduler.app.persistence.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.studyfocusscheduler.app.data.vos.NoteWithReminderVO
import com.studyfocusscheduler.app.data.vos.ReminderVO

@Dao
interface ReminderDao {

    @Insert
    suspend fun insertReminder(reminder: ReminderVO)

    @Transaction
    @Query("SELECT * FROM note WHERE noteId = :noteId")
    suspend fun getNoteWithReminder(noteId: Int): NoteWithReminderVO?

    @Update
    suspend fun updateReminder(reminder: ReminderVO)

    @Delete
    suspend fun deleteReminder(reminder: ReminderVO)
}