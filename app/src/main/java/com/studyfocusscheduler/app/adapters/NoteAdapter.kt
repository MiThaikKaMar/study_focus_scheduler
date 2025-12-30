package com.studyfocusscheduler.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.studyfocusscheduler.app.data.vos.FolderVO
import com.studyfocusscheduler.app.data.vos.NoteVO
import com.studyfocusscheduler.app.databinding.ItemFolderBinding
import com.studyfocusscheduler.app.databinding.ItemNoteBinding
import com.studyfocusscheduler.app.delegates.TalkNoteDelegate
import com.studyfocusscheduler.app.views.viewholders.BaseViewHolder
import com.studyfocusscheduler.app.views.viewholders.FolderViewHolder
import com.studyfocusscheduler.app.views.viewholders.NoteViewHolder

class NoteAdapter(private val mDelegate: TalkNoteDelegate): BaseAdapter<BaseViewHolder<NoteVO>, NoteVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<NoteVO> {
        val binding = ItemNoteBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding,mDelegate)

    }
}