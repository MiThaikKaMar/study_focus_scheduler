package com.studyfocusscheduler.app.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.studyfocusscheduler.app.data.model.TalkNoteModel
import com.studyfocusscheduler.app.data.model.impls.TalkNoteModelImpl

abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView){

    var mData : T? = null
    val mModel : TalkNoteModel = TalkNoteModelImpl

    abstract fun bindData(data : T)
}