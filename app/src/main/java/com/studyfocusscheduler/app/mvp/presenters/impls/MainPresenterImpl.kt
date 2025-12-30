package com.studyfocusscheduler.app.mvp.presenters.impls

import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.studyfocusscheduler.app.activities.BaseActivity
import com.studyfocusscheduler.app.activities.MainActivity
import com.studyfocusscheduler.app.data.vos.FolderVO
import com.studyfocusscheduler.app.data.vos.NoteVO
import com.studyfocusscheduler.app.fragments.CreateFolderDialog
import com.studyfocusscheduler.app.mvp.presenters.AbstractBasePresenter
import com.studyfocusscheduler.app.mvp.presenters.MainPresenter
import com.studyfocusscheduler.app.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    private lateinit var mLifecycleOwner: LifecycleOwner

    override fun onUiReady(lifeCycleOwner: LifecycleOwner, context: Context) {
        val initialFolderVo = FolderVO(1, "General", 0)
        mLifecycleOwner = lifeCycleOwner

        //observe folder list changes
        mTalkNoteModel.getLiveFolders().observe(lifeCycleOwner, Observer {
            if (it.isEmpty()) {
                //if there's no folder, auto create general folder
                mTalkNoteModel.addFolderToDb(initialFolderVo)
            }

            mView?.showFolderList(it)

        })

        //open added new folder
        BaseActivity.addFolderVo.observe(lifeCycleOwner){
            mTalkNoteModel.getLiveNotes(it.folderId).observe(mLifecycleOwner) {noteList->
                mView?.showNotesInFolder(it, noteList)
            }
        }
        
        //show initial notes in general folder
        mView?.showNotesInFolder(
            initialFolderVo,
            mTalkNoteModel.getNotes(initialFolderVo.folderId)
        )

    }

    override fun onModeSwitchClicked(checked: Boolean) {
        mView?.setNightModeChecked(checked)
    }

    override fun onAddNoteClicked() {
        mView?.navToAddNote()

    }

    override fun onAddFolderClicked() {
        mView?.showCreateFolderDialog()
    }

    override fun onTapFolder(folder: FolderVO) {
        mTalkNoteModel.getLiveNotes(folder.folderId).observe(mLifecycleOwner) {
            mView?.showNotesInFolder(folder, it)
        }


    }

    override fun onTapNote(note: NoteVO) {
        mView?.navToViewNote(note)
    }

}