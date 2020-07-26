package com.dsm.cms.domain.repository

import com.dsm.cms.domain.entity.Post

interface PostRepository {
    suspend fun getPosts(type: String, clubName: String = ""): List<Post>

    suspend fun getDetailPost(postId: Int): Post
}