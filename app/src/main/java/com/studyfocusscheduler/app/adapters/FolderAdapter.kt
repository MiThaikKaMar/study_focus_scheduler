package com.studyfocusscheduler.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.studyfocusscheduler.app.data.vos.FolderVO
import com.studyfocusscheduler.app.databinding.ItemFolderBinding
import com.studyfocusscheduler.app.delegates.TalkNoteDelegate
import com.studyfocusscheduler.app.views.viewholders.BaseViewHolder
import com.studyfocusscheduler.app.views.viewholders.FolderViewHolder

class FolderAdapter(private val lifecycleOwner: LifecycleOwner,private val mDelegate: TalkNoteDelegate): BaseAdapter<BaseViewHolder<FolderVO>, FolderVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<FolderVO> {
        val binding = ItemFolderBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return FolderViewHolder(lifecycleOwner,binding,mDelegate)

    }
}