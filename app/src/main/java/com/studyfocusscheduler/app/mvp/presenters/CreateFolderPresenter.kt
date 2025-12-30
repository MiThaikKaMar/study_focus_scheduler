package com.studyfocusscheduler.app.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.studyfocusscheduler.app.mvp.views.CreateFolderView

interface CreateFolderPresenter : BasePresenter<CreateFolderView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun onCancelClicked()
    fun onAddClicked(folderName:String)
}