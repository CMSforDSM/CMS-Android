package com.dsm.cms.domain.entity

import com.google.gson.annotations.SerializedName

data class Post(

    @SerializedName("post_id")
    val postId: Int,

    val club: String,

    @SerializedName("post_type")
    val postType: String,

    val writer: String,

    val title: String,

    val content: String,

    @SerializedName("date_time")
    val dateTime: String
)
