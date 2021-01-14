package com.project.starbucks_app.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.starbucks_app.data.local.entity.MenuItem
import com.project.starbucks_app.databinding.ItemMenuBinding

class HomeMenuAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList = arrayListOf<MenuItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MainViewHolder -> holder.bind(dataList[position])
        }
    }

    override fun getItemCount(): Int = dataList.size

    fun setItem(data : List<MenuItem>){
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    class MainViewHolder(private val binding : ItemMenuBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: com.project.starbucks_app.data.local.entity.MenuItem){
            binding.item = data
        }
    }

}