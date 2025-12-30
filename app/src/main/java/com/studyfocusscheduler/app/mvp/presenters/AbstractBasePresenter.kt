package com.studyfocusscheduler.app.mvp.presenters

import androidx.lifecycle.ViewModel
import com.studyfocusscheduler.app.data.model.TalkNoteModel
import com.studyfocusscheduler.app.data.model.impls.TalkNoteModelImpl
import com.studyfocusscheduler.app.mvp.views.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null
    val mTalkNoteModel : TalkNoteModel = TalkNoteModelImpl

    override fun initPresenter(view: T) {
        mView = view
    }
}