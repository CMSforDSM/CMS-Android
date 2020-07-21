package com.dsm.cms.data.repository

import com.dsm.cms.data.datasource.RemotePostDataSource
import com.dsm.cms.domain.entity.Post
import com.dsm.cms.domain.repository.PostRepository

class PostRepositoryImpl(
    private val remotePostDataSource: RemotePostDataSource
) : PostRepository {
    override suspend fun getPosts(type: String): List<Post> {
        return remotePostDataSource.getPosts(type)
    }
}