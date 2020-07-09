package com.dsm.cms.data.pref

import com.dsm.cms.domain.entity.Student

interface PrefStorage {
    // token
    fun setAccessToken(accessToken: String)
    fun getAccessToken(): String
    fun deleteAccessToken()
    fun setRefreshToken(refreshToken: String)
    fun getRefreshToken(): String
    fun deleteRefreshToken()

    // student
    fun setStudent(student: Student)
    fun getStudent(): Student
    fun deleteStudent()
}