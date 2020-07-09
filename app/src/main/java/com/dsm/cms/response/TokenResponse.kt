package com.dsm.cms.response

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)