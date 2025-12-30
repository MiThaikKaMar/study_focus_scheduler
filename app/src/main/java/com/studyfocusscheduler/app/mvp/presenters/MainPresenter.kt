package com.studyfocusscheduler.app.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.studyfocusscheduler.app.delegates.TalkNoteDelegate
import com.studyfocusscheduler.app.fragments.CreateFolderDialog
import com.studyfocusscheduler.app.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView> , TalkNoteDelegate{
    fun onUiReady(lifeCycleOwner: LifecycleOwner,context:Context)
    fun onModeSwitchClicked(checked:Boolean)
    fun onAddNoteClicked()
    fun onAddFolderClicked()
}