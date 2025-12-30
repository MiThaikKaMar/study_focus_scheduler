package com.studyfocusscheduler.app.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.studyfocusscheduler.app.activities.BaseActivity
import com.studyfocusscheduler.app.activities.MainActivity
import com.studyfocusscheduler.app.data.model.TalkNoteModel
import com.studyfocusscheduler.app.data.model.impls.TalkNoteModelImpl
import com.studyfocusscheduler.app.data.vos.FolderVO
import com.studyfocusscheduler.app.fragments.CreateFolderDialog
import com.studyfocusscheduler.app.mvp.presenters.AbstractBasePresenter
import com.studyfocusscheduler.app.mvp.presenters.CreateFolderPresenter
import com.studyfocusscheduler.app.mvp.presenters.MainPresenter
import com.studyfocusscheduler.app.mvp.views.CreateFolderView
import com.studyfocusscheduler.app.mvp.views.MainView



class CreateFolderPresenterImpl: CreateFolderPresenter, AbstractBasePresenter<CreateFolderView>() {

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        TODO("Not yet implemented")
    }

    override fun onCancelClicked() {
        mView?.cancelDialog()
    }

    override fun onAddClicked(folderName:String) {
        val addedFolderVo = FolderVO(0,folderName,0)
        mTalkNoteModel.addFolderToDb(addedFolderVo)
        mView?.addFolder()
        BaseActivity.addFolderVo.value = mTalkNoteModel.getFolders().lastOrNull()

    }

}