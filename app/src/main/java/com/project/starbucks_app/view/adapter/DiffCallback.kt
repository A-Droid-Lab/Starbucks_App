package com.project.starbucks_app.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.project.starbucks_app.data.local.entity.MenuItem

class DiffCallback (
        private val oldData : ArrayList<MenuItem>,
        private val newData : List<MenuItem>
) : DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldData.size

    override fun getNewListSize(): Int = newData.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
            = oldData[oldItemPosition].id == newData[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
            = oldData[oldItemPosition] == newData[newItemPosition]

}