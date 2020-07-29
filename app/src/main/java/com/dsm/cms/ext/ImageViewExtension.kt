package com.dsm.cms.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageRes")
fun ImageView.setImageUrl(url: String?) {
    url?.let{
        Glide.with(this.context).load(it).into(this)
    }
}