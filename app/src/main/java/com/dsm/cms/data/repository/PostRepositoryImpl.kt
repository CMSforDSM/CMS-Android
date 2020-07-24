package com.dsm.cms.data.repository

import com.dsm.cms.data.datasource.RemotePostDataSource
import com.dsm.cms.domain.entity.Post
import com.dsm.cms.domain.repository.PostRepository
import com.dsm.cms.ext.setDateAsOfToday

class PostRepositoryImpl(
    private val remotePostDataSource: RemotePostDataSource
) : PostRepository {
    override suspend fun getPosts(type: String, clubName: String): List<Post> {
        val posts = remotePostDataSource.getPosts(type, clubName)

        posts.forEach { it.dateTime = setDateAsOfToday(it.dateTime) }

        return posts
    }
}