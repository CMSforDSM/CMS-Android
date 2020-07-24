package com.dsm.cms.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dsm.cms.domain.entity.Club
import com.dsm.cms.domain.entity.Post
import com.dsm.cms.ui.adapter.MainClubAdapter
import com.dsm.cms.ui.adapter.MainPostAdapter

@BindingAdapter("clubs_list")
fun RecyclerView.setClubsInRv(clubs: List<Club>) {
    val adapter = adapter as MainClubAdapter
    adapter.setList(clubs)
}


@BindingAdapter("post_list")
fun RecyclerView.setPostInRv(posts: List<Post>) {
    val adapter = adapter as MainPostAdapter
    adapter.setList(posts)
}