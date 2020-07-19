package com.dsm.cms.domain.entity

import com.google.gson.annotations.SerializedName

data class Club(
	val leader: String,
	val introduce: String,
	val members: List<String>,
	val logo: String,
	@SerializedName("club_name")
	val clubName: String
) {
	override fun toString(): String {
		return "$leader, $introduce, $members, $logo, $clubName"
	}
}

