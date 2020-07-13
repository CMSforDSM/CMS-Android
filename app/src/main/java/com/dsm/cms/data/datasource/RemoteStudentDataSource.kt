package com.dsm.cms.data.datasource

import com.dsm.cms.data.api.CmsApi
import com.dsm.cms.domain.entity.Student

interface RemoteStudentDataSource {
    suspend fun getStudentInfo(): Student
}

class RemoteStudentDataSourceImpl(
    private val cmsApi: CmsApi
) : RemoteStudentDataSource {
    override suspend fun getStudentInfo(): Student {
        return try {
            cmsApi.getStudentInfo()
        } catch (e: Exception) {
            throw e.cause!!
        }
    }
}