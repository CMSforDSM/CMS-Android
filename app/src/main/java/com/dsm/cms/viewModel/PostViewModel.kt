package com.dsm.cms.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel

class PostViewModel(
    private val postId: Int
) : ViewModel() {
    init {
        Log.d("postId in ViewModel", "$postId")
    }
}