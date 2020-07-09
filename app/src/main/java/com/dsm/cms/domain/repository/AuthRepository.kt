package com.dsm.cms.domain.repository

interface AuthRepository {
    suspend fun login(body: Any)
}