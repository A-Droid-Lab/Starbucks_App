package com.project.starbucks_app.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.project.starbucks_app.data.local.entity.MenuItem
import com.project.starbucks_app.databinding.ItemMenuBinding
import com.project.starbucks_app.util.ViewType
import com.project.starbucks_app.util.ViewType.Companion.COFFEE
import com.project.starbucks_app.util.ViewType.Companion.FRAPUCCINO


class CoffeeMenuAdapter(private val type:String) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var dataList: ArrayList<MenuItem> = ArrayList()

    private var listener: ((item: MenuItem, view:ImageView, ivName:String) -> Unit)? = null


    fun setOnItemClickListener(listener: (item: MenuItem, view:ImageView, ivName:String) -> Unit) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        @ViewType.CoffeeType
        return when(type){
            COFFEE -> { CoffeeViewHolder(binding) }
            FRAPUCCINO -> { FrapuccinoViewHolder(binding) }
            else -> { BlendedViewHolder(binding) }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CoffeeViewHolder -> holder.bind(dataList[position],position)
            is FrapuccinoViewHolder -> holder.bind(dataList[position],position)
            is BlendedViewHolder -> holder.bind(dataList[position],position)
        }
    }

    override fun getItemCount(): Int = dataList.size

    fun setItem(data : List<MenuItem>){
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    inner class CoffeeViewHolder(private val binding : ItemMenuBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: com.project.starbucks_app.data.local.entity.MenuItem, position: Int){
            binding.item = data
            itemView.setOnClickListener {
                listener?.invoke(data, binding.ivMenuImage, binding.ivMenuImage.transitionName+position)
            }
        }
    }

    inner class FrapuccinoViewHolder(private val binding : ItemMenuBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: com.project.starbucks_app.data.local.entity.MenuItem, position: Int){
            binding.item = data
            itemView.setOnClickListener {
                listener?.invoke(data, binding.ivMenuImage, binding.ivMenuImage.transitionName+position)
            }
        }
    }

    inner class BlendedViewHolder(private val binding : ItemMenuBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: com.project.starbucks_app.data.local.entity.MenuItem, position: Int){
            binding.item = data
            itemView.setOnClickListener {
                listener?.invoke(data, binding.ivMenuImage,binding.ivMenuImage.transitionName+position)
            }
        }
    }


}