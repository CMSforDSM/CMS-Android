package com.dsm.cms.data.datasource

import com.dsm.cms.data.api.CmsApi
import com.dsm.cms.domain.entity.Student
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface RemoteStudentDataSource {
    suspend fun getStudentInfo(): Student
}

class RemoteStudentDataSourceImpl(
    private val cmsApi: CmsApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : RemoteStudentDataSource {
    override suspend fun getStudentInfo(): Student = withContext(ioDispatcher) {
        try {
            cmsApi.getStudentInfo()
        } catch (e: Exception) {
            throw e.cause!!
        }
    }
}