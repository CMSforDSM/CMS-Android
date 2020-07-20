package com.dsm.cms.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dsm.cms.domain.entity.Club
import com.dsm.cms.ui.adapter.MainClubAdapter

@BindingAdapter("clubs_list")
fun RecyclerView.setClubsInMain(clubs: List<Club>) {
    val adapter = adapter as MainClubAdapter
    adapter.setList(clubs)
}
