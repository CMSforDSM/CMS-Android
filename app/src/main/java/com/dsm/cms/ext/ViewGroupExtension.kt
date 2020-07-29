package com.dsm.cms.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dsm.cms.domain.entity.Club
import com.dsm.cms.domain.entity.Post
import com.dsm.cms.ui.adapter.ClubAdapter
import com.dsm.cms.ui.adapter.MemberAdapter
import com.dsm.cms.ui.adapter.ResumeAdapter
import com.dsm.cms.ui.adapter.PostAdapter

@BindingAdapter("clubs_list")
fun RecyclerView.setClubsInRv(clubs: List<Club>) {
    val adapter = adapter as ClubAdapter
    adapter.setList(clubs)
}

@BindingAdapter("post_list")
fun RecyclerView.setPostInRv(posts: List<Post>) {
    val adapter = adapter as PostAdapter
    adapter.setList(posts)
}

@BindingAdapter("resume_list")
fun RecyclerView.setResumeInRv(posts: List<Post>) {
    val adapter = adapter as ResumeAdapter
    adapter.setList(posts)
}

@BindingAdapter("member_list")
fun RecyclerView.setMemberInRv(member: List<String>) {
    val adapter = adapter as MemberAdapter
    adapter.setList(member)
}