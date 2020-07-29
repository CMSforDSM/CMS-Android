package com.dsm.cms.domain.entity

import com.dsm.cms.ext.setDateManually
import com.google.gson.annotations.SerializedName
import java.io.Serializable

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
    var dateTime: String
) : Serializable {
    override fun toString(): String {
        return "$postId, $club, $postType, $writer, $title, $content, $dateTime"
    }

    fun merge(post: Post): Post {
        post.dateTime = setDateManually(this.dateTime)
        return post
    }
}
