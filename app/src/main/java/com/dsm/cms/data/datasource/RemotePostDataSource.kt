package com.dsm.cms.data.datasource

import com.dsm.cms.data.api.CmsApi
import com.dsm.cms.domain.entity.Post

interface RemotePostDataSource {
    suspend fun getPosts(type: String): List<Post>
}

class RemotePostDataSourceImpl(
    private val cmsApi: CmsApi
) : RemotePostDataSource {
    override suspend fun getPosts(type: String): List<Post> {
        return try {
            cmsApi.getPosts(type)
        } catch (e: Exception) {
            throw e.cause!!
        }
    }
}

