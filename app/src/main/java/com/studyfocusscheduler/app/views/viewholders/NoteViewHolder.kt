package com.studyfocusscheduler.app.views.viewholders

import com.studyfocusscheduler.app.data.vos.FolderVO
import com.studyfocusscheduler.app.data.vos.NoteVO
import com.studyfocusscheduler.app.databinding.ItemFolderBinding
import com.studyfocusscheduler.app.databinding.ItemNoteBinding
import com.studyfocusscheduler.app.delegates.TalkNoteDelegate

class NoteViewHolder(private val binding: ItemNoteBinding, delegate: TalkNoteDelegate) : BaseViewHolder<NoteVO>(binding.root) {

    init {
        binding.root.setOnClickListener {
            mData?.let {
                delegate.onTapNote(it)
            }
        }
    }

    override fun bindData(data: NoteVO) {
        mData=data

        binding.tvNoteTitle.text = mData?.title
        binding.tvNoteDate.text = mData?.timestamp.toString()
    }
}