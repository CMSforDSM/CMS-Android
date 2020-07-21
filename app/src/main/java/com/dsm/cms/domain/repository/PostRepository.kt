package com.dsm.cms.domain.repository

import com.dsm.cms.domain.entity.Post

interface PostRepository {
    suspend fun getPosts(type: String): List<Post>
}