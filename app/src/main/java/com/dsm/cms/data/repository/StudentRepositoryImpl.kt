package com.dsm.cms.data.repository

import com.dsm.cms.data.datasource.RemoteStudentDataSource
import com.dsm.cms.data.pref.PrefStorage
import com.dsm.cms.domain.repository.StudentRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class StudentRepositoryImpl(
    private val remoteStudentDataSource: RemoteStudentDataSource,
    private val prefStorage: PrefStorage
) : StudentRepository {
    override suspend fun getStudentInfo() {
        val response = remoteStudentDataSource.getStudentInfo()
        prefStorage.setStudent(response)
    }
}