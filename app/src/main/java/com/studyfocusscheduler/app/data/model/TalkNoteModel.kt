package com.studyfocusscheduler.app.data.model

import androidx.lifecycle.LiveData
import com.studyfocusscheduler.app.data.vos.FolderVO
import com.studyfocusscheduler.app.data.vos.NoteVO

interface TalkNoteModel {

    fun setNoteToDb(noteVO: NoteVO)

    fun addFolderToDb(folderVO: FolderVO)
    fun getLiveFolders():LiveData<List<FolderVO>>
    fun getFolderCount():LiveData<Int>
    fun getFolders():List<FolderVO>

    fun getLiveNotes(folderId : Int):LiveData<List<NoteVO>>
    fun getNotes(folderId: Int):List<NoteVO>

    fun getNoteCountInFolder(folderId: Int):LiveData<Int>
}