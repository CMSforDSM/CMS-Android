package com.dsm.cms.data.api

import com.dsm.cms.domain.entity.Student
import com.dsm.cms.response.TokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CmsApi {
    // auth
    @POST("auth/login")
    suspend fun login(@Body body: Any): TokenResponse

    // student
    @GET("users/me")
    suspend fun getStudentInfo(): Student
}