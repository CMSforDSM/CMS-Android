package com.dsm.cms.ext

import androidx.databinding.BindingAdapter
import com.dsm.cms.domain.entity.Student
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.drawer_header.view.*

@BindingAdapter("setStudentInHeader")
fun NavigationView.setStudentInfo(student: Student) {
    val view = this.getHeaderView(0)
    view.tv_student_name_drawer.text = student.name
    view.tv_student_info_drawer.text = student.introduce
}