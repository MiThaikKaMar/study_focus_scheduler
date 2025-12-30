package com.studyfocusscheduler.app.views.viewholders

import androidx.lifecycle.LifecycleOwner
import com.studyfocusscheduler.app.data.model.TalkNoteModel
import com.studyfocusscheduler.app.data.vos.FolderVO
import com.studyfocusscheduler.app.databinding.ItemFolderBinding
import com.studyfocusscheduler.app.delegates.TalkNoteDelegate

class FolderViewHolder(private val lifecycleOwner: LifecycleOwner,private val binding: ItemFolderBinding,delegate: TalkNoteDelegate) : BaseViewHolder<FolderVO>(binding.root) {

    init {
        binding.root.setOnClickListener {
            mData?.let {
                delegate.onTapFolder(it)
            }
        }
    }

    override fun bindData(data: FolderVO) {
        mData=data

        mModel.getNoteCountInFolder(data.folderId).observe(lifecycleOwner){
            binding.tvFolderSize.text = it.toString()
        }
        binding.tvFolderTitle.text = mData?.name
    }
}