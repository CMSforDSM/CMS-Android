package com.dsm.cms.data.datasource

import com.dsm.cms.data.api.CmsApi
import com.dsm.cms.response.TokenResponse

interface RemoteAuthDataSource {
    suspend fun login(body: Any): TokenResponse
}

class RemoteAuthDataSourceImpl(
    private val cmsApi: CmsApi
) : RemoteAuthDataSource {
    override suspend fun login(body: Any): TokenResponse {
        return try {
            cmsApi.login(body)
        } catch (e: Exception) {
            throw e.cause!!
        }
    }
}