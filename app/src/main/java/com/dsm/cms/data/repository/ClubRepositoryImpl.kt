package com.dsm.cms.data.repository

import com.dsm.cms.data.datasource.RemoteClubDataSource
import com.dsm.cms.domain.entity.Club
import com.dsm.cms.domain.repository.ClubRepository

class ClubRepositoryImpl(
    private val remoteClubDataSource: RemoteClubDataSource
) : ClubRepository {
    override suspend fun getClubInfo(clubName: String): Club {
        return remoteClubDataSource.getClubInfo(clubName)
    }

    override suspend fun getClubsInfo(): List<Club> {
        return remoteClubDataSource.getClubsInfo()
    }

    override suspend fun scoutStudent(body: Any) {
        return remoteClubDataSource.scoutStudent(body)
    }

    override suspend fun applyClub(body: Any) {
        return remoteClubDataSource.applyClub(body)
    }

}