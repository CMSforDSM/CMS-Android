package com.dsm.cms.data.repository

import com.dsm.cms.data.datasource.RemoteStudentDataSource
import com.dsm.cms.data.pref.PrefStorage
import com.dsm.cms.domain.repository.StudentRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StudentRepositoryImpl(
    private val remoteStudentDataSource: RemoteStudentDataSource,
    private val prefStorage: PrefStorage,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : StudentRepository {
    override suspend fun getStudentInfo() = withContext(ioDispatcher) {
        val response = remoteStudentDataSource.getStudentInfo()
        prefStorage.setStudent(response)
    }
}