package com.studyfocusscheduler.app.data.model.impls

import android.util.Log
import androidx.lifecycle.LiveData
import com.studyfocusscheduler.app.data.model.BaseModel
import com.studyfocusscheduler.app.data.model.TalkNoteModel
import com.studyfocusscheduler.app.data.vos.FolderVO
import com.studyfocusscheduler.app.data.vos.NoteVO

object TalkNoteModelImpl:TalkNoteModel,BaseModel() {
    override fun setNoteToDb(noteVO: NoteVO) {
        mTalkNoteDB.noteDao().insertNote(noteVO)
   }

    override fun addFolderToDb(folderVO: FolderVO) {
        mTalkNoteDB.folderDao().insertFolder(folderVO)
    }

    override fun getLiveFolders() : LiveData<List<FolderVO>>{
        return mTalkNoteDB.folderDao().getLiveFolders()
    }

    override fun getFolderCount(): LiveData<Int> {
        return mTalkNoteDB.folderDao().getFolderCount()
    }

    override fun getFolders(): List<FolderVO> {
        return mTalkNoteDB.folderDao().getFolders()
    }

    override fun getLiveNotes(folderId: Int): LiveData<List<NoteVO>> {
        return mTalkNoteDB.noteDao().getLiveNotes(folderId)
    }

    override fun getNotes(folderId: Int): List<NoteVO> {
        return mTalkNoteDB.noteDao().getNotes(folderId)
    }

    override fun getNoteCountInFolder(folderId: Int): LiveData<Int> {
        return mTalkNoteDB.noteDao().getNoteCountInFolder(folderId)
    }
}