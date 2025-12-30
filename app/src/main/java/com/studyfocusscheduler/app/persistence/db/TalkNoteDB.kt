package com.studyfocusscheduler.app.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.studyfocusscheduler.app.data.vos.FolderVO
import com.studyfocusscheduler.app.data.vos.NoteVO
import com.studyfocusscheduler.app.data.vos.ReminderVO
import com.studyfocusscheduler.app.persistence.daos.FolderDao
import com.studyfocusscheduler.app.persistence.daos.NoteDao
import com.studyfocusscheduler.app.persistence.daos.ReminderDao

@Database(entities = [NoteVO::class,FolderVO::class,ReminderVO::class], version = 2, exportSchema = false)
    abstract class TalkNoteDB : RoomDatabase() {
    companion object {
        val DB_NAME = "TALK_NOTE.DB"
        var dbInstance: TalkNoteDB? = null

        fun getDBInstance(context: Context): TalkNoteDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, TalkNoteDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }

    abstract fun noteDao(): NoteDao
    abstract fun folderDao(): FolderDao
    abstract fun reminderDao(): ReminderDao

}