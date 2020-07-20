package com.dsm.cms.data.datasource

import com.dsm.cms.data.api.CmsApi
import com.dsm.cms.domain.entity.Club

interface RemoteClubDataSource {
    suspend fun getClubInfo(clubName: String): Club

    suspend fun getClubsInfo(): List<Club>
}

class RemoteClubDataSourceImpl(
    private val cmsApi: CmsApi
) : RemoteClubDataSource {
    override suspend fun getClubInfo(clubName: String): Club {
        return try {
            cmsApi.getClubInfo(clubName)
        } catch (e: Exception) {
            throw e.cause!!
        }
    }

    override suspend fun getClubsInfo(): List<Club> {
        return try {
            cmsApi.getClubsInfo()
        } catch (e: Exception) {
            throw e.cause!!
        }
    }
}