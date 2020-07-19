package com.dsm.cms.data.repository

import com.dsm.cms.data.datasource.RemoteClubDataSource
import com.dsm.cms.domain.entity.Club
import com.dsm.cms.domain.repository.ClubRepository

class ClubRepositoryImpl(
    private val remoteClubDataSource: RemoteClubDataSource
) : ClubRepository {
override suspend fun getClubInfo(clubName: String): Club =
    remoteClubDataSource.getClubInfo(clubName)
}