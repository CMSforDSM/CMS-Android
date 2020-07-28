package com.dsm.cms.domain.repository

import com.dsm.cms.domain.entity.Club

interface ClubRepository {
    suspend fun getClubInfo(clubName: String): Club

    suspend fun getClubsInfo(): List<Club>

    suspend fun scoutStudent(body: Any)
}