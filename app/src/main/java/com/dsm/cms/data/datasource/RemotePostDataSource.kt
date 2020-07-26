package com.dsm.cms.data.datasource

import com.dsm.cms.data.api.CmsApi
import com.dsm.cms.domain.entity.Post

interface RemotePostDataSource {
    suspend fun getPosts(type: String, clubName: String = ""): List<Post>

    suspend fun getDetailPost(postId: Int): Post
}

class RemotePostDataSourceImpl(
    private val cmsApi: CmsApi
) : RemotePostDataSource {
    override suspend fun getPosts(type: String, clubName: String): List<Post> {
        return try {
            if (clubName.isBlank()) {
                cmsApi.getPosts(type)
            } else {
                cmsApi.getPosts(type, clubName)
            }
        } catch (e: Exception) {
            throw e.cause!!
        }
    }

    override suspend fun getDetailPost(postId: Int): Post {
        return try {
            cmsApi.getDetailPost(postId)
        } catch (e: Exception) {
            throw e.cause!!
        }
    }
}

