package com.dsm.cms.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dsm.cms.domain.entity.Club
import com.dsm.cms.domain.entity.Post
import com.dsm.cms.ui.adapter.MainClubAdapter
import com.dsm.cms.ui.adapter.MainRecruitmentAdapter

@BindingAdapter("clubs_list")
fun RecyclerView.setClubsInRv(clubs: List<Club>) {
    val adapter = adapter as MainClubAdapter
    adapter.setList(clubs)
}


@BindingAdapter("recruitment_list")
fun RecyclerView.setRecruitmentsInRv(posts: List<Post>) {
    val adapter = adapter as MainRecruitmentAdapter
    adapter.setList(posts)
}