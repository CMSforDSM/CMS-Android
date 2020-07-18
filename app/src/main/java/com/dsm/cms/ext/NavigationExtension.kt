package com.dsm.cms.ext

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.dsm.cms.domain.entity.Club
import com.dsm.cms.domain.entity.Student
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.nav_header.view.*

@BindingAdapter("setClubInHeader")
fun NavigationView.setClubInfo(club: Club) {
    val view = this.getHeaderView(0)
    view.tv_club_name_header.text = club.clubName
    view.tv_club_info_header.text = club.introduce
    Glide.with(this.context).load(club.logo).into(view.iv_club_icon_header)
}

@BindingAdapter("setStudentInHeader")
fun NavigationView.setStudentInfo(student: Student) {
    val view = this.getHeaderView(0)
    view.tv_student_name_drawer.text = student.name
    view.tv_student_info_drawer.text = student.introduce
}
