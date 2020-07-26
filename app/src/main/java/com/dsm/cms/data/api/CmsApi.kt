package com.dsm.cms.data.api

import com.dsm.cms.domain.entity.Club
import com.dsm.cms.domain.entity.Post
import com.dsm.cms.domain.entity.Student
import com.dsm.cms.response.TokenResponse
import retrofit2.http.*

interface CmsApi {
    // auth
    @POST("auth/login")
    suspend fun login(@Body body: Any): TokenResponse

    // student
    @GET("users/me")
    suspend fun getStudentInfo(): Student

    // club
    @GET("clubs/{clubName}")
    suspend fun getClubInfo(@Path("clubName") clubName: String): Club

    @GET("clubs")
    suspend fun getClubsInfo(): List<Club>

    // post
    @GET("posts")
    suspend fun getPosts(
        @Query("type") type: String
    ): List<Post>

    @GET("posts")
    suspend fun getPosts(
        @Query("type") type: String,
        @Query("club") clubName: String
    ): List<Post>

    @GET("posts/{post_id}")
    suspend fun getDetailPost(
        @Path("post_id") postId: Int
    ): Post
}