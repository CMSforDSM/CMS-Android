package com.dsm.cms.data.api

import com.dsm.cms.response.TokenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface CmsApi {
    @POST("auth/login")
    suspend fun login(@Body body: Any): TokenResponse
}