package com.dsm.cms.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsm.cms.domain.entity.Post
import com.dsm.cms.domain.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel(
    private val beforePost: Post,
    private val postRepository: PostRepository
) : ViewModel() {
    private val _detailPost = MutableLiveData(Post(-1, "", "", "", "", "", ""))
    val detailPost: LiveData<Post> = _detailPost

    init {
        setDetailPost()
    }

    private fun setDetailPost() = viewModelScope.launch {
        _detailPost.value = beforePost.merge(
            postRepository.getDetailPost(beforePost.postId)
        )
    }
}