package com.studyfocusscheduler.app.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.studyfocusscheduler.app.activities.BaseActivity
import com.studyfocusscheduler.app.data.model.TalkNoteModel
import com.studyfocusscheduler.app.data.model.impls.TalkNoteModelImpl
import com.studyfocusscheduler.app.data.vos.NoteVO
import com.studyfocusscheduler.app.fragments.CreateFolderDialog
import com.studyfocusscheduler.app.mvp.presenters.AbstractBasePresenter
import com.studyfocusscheduler.app.mvp.presenters.AddNotePresenter
import com.studyfocusscheduler.app.mvp.presenters.MainPresenter
import com.studyfocusscheduler.app.mvp.views.AddNoteView
import com.studyfocusscheduler.app.mvp.views.MainView

class AddNotePresenterImpl: AddNotePresenter, AbstractBasePresenter<AddNoteView>() {


    override fun onUiReady(lifeCycleOwner: LifecycleOwner,context:Context) {
        //Toast.makeText(context, "Presenter Setup", Toast.LENGTH_SHORT).show()
        mView?.initView()
    }

    override fun onClickedSave(noteVo: NoteVO) {
        mTalkNoteModel.setNoteToDb(noteVo)
        mView?.closeAddNoteScreen()

    }


}