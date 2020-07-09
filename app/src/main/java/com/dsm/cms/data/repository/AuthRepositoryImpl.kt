package com.dsm.cms.data.repository

import com.dsm.cms.data.datasource.RemoteAuthDataSource
import com.dsm.cms.data.pref.PrefStorage
import com.dsm.cms.domain.repository.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepositoryImpl(
    private val remoteAuthDataSource: RemoteAuthDataSource,
    private val prefStorage: PrefStorage,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : AuthRepository {
    override suspend fun login(body: Any) = withContext(ioDispatcher) {
        val response = remoteAuthDataSource.login(body)
        prefStorage.setAccessToken(response.accessToken)
        prefStorage.setRefreshToken(response.refreshToken)
    }
}