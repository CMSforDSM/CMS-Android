package com.dsm.cms.data.repository

import com.dsm.cms.data.datasource.RemoteAuthDataSource
import com.dsm.cms.data.pref.PrefStorage
import com.dsm.cms.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val remoteAuthDataSource: RemoteAuthDataSource,
    private val prefStorage: PrefStorage
) : AuthRepository {
    override suspend fun login(body: Any) {
        val response = remoteAuthDataSource.login(body)
        prefStorage.setAccessToken(response.accessToken)
        prefStorage.setRefreshToken(response.refreshToken)
    }
}