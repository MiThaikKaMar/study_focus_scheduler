package com.studyfocusscheduler.app.adapters

import androidx.recyclerview.widget.RecyclerView
import com.studyfocusscheduler.app.views.viewholders.BaseViewHolder

abstract class BaseAdapter<T : BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {
    var mData: MutableList<W> = arrayListOf()

    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    fun setData(data : MutableList<W>){
        mData = data
        notifyDataSetChanged()
    }

    fun addData(data : W){
        mData.add(data)
        notifyDataSetChanged()
    }
}