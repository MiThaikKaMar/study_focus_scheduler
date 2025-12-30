package com.studyfocusscheduler.app.mvp.views

import com.studyfocusscheduler.app.data.vos.FolderVO
import com.studyfocusscheduler.app.data.vos.NoteVO

interface MainView: BaseView {

    fun setNightModeChecked(checked: Boolean)
    fun navToAddNote()
    fun showFolderList(list : List<FolderVO>)
    fun showCreateFolderDialog()
    fun showNotesInFolder(folderVO: FolderVO, noteList: List<NoteVO>)
    fun navToViewNote(noteVO: NoteVO)


}