package com.dsm.cms.domain.repository

interface StudentRepository {
    suspend fun getStudentInfo()
}