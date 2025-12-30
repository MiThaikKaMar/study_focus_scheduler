package com.studyfocusscheduler.app.mvp.views

import com.studyfocusscheduler.app.data.vos.NoteVO

interface ViewNoteView: BaseView {

    fun displayNoteInfo(noteVO: NoteVO)
}