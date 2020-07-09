package com.dsm.cms.data.datasource

import com.dsm.cms.data.api.CmsApi
import com.dsm.cms.response.TokenResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface RemoteAuthDataSource {
    suspend fun login(body: Any): TokenResponse
}

class RemoteAuthDataSourceImpl(
    private val cmsApi: CmsApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : RemoteAuthDataSource {
    override suspend fun login(body: Any): TokenResponse = withContext(ioDispatcher) {
            try {
                cmsApi.login(body)
            } catch (e: Exception) {
                throw e.cause!!
            }
        }
}