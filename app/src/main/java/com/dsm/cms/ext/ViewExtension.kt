package com.dsm.cms.ext

import android.widget.Button
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.dsm.cms.R

@BindingAdapter("imageRes")
fun ImageView.setImageUrl(url: String?) {
    url?.let {
        Glide.with(this.context).load(it).into(this)
    }
}

@BindingAdapter(value = ["club_name", "std_club_status"])
fun Button.setApplyBtnTextClickable(clubName: String, stdClub: String?) {
    when {
        stdClub == null || stdClub == "" -> {
            this.isEnabled = true
            this.text = context.getString(R.string.apply_club)
        }
        clubName == stdClub -> {
            this.isEnabled = false
            this.text = context.getString(R.string.my_club)
        }
        clubName != stdClub -> {
            this.isEnabled = false
            this.text = context.getString(R.string.not_my_club)
        }
    }
}
