package com.studyfocusscheduler.app.delegates

import com.studyfocusscheduler.app.data.vos.FolderVO
import com.studyfocusscheduler.app.data.vos.NoteVO

interface TalkNoteDelegate {
    fun onTapFolder(folder:FolderVO)
    fun onTapNote(note:NoteVO)
}