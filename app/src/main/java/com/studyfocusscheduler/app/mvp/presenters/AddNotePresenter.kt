package com.studyfocusscheduler.app.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.studyfocusscheduler.app.data.vos.NoteVO
import com.studyfocusscheduler.app.mvp.views.AddNoteView
import com.studyfocusscheduler.app.mvp.views.MainView

interface AddNotePresenter : BasePresenter<AddNoteView> {
    fun onUiReady(lifeCycleOwner: LifecycleOwner,context:Context)

    fun onClickedSave(noteVo:NoteVO)

}