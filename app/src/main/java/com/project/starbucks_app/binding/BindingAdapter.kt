package com.project.starbucks_app.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("loadImage")
fun setImageUrl(view : ImageView, url : String?){
    if(!url.isNullOrEmpty()){
        Glide.with(view.context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .centerCrop()
                .into(view)
    }
}