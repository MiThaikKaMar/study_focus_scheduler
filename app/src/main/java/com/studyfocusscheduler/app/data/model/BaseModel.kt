package com.studyfocusscheduler.app.data.model

import android.content.Context
import com.studyfocusscheduler.app.persistence.db.TalkNoteDB

abstract class BaseModel {

    protected lateinit var mTalkNoteDB: TalkNoteDB

    fun initDatabase(context: Context){
        mTalkNoteDB = TalkNoteDB.getDBInstance(context)
    }
}