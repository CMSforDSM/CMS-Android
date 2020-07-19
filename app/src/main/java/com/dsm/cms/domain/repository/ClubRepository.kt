package com.dsm.cms.domain.repository

import com.dsm.cms.domain.entity.Club

interface ClubRepository {
    suspend fun getClubInfo(clubName: String): Club
}