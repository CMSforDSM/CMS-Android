package com.dsm.cms.ui.activity

import android.os.Bundle
import android.util.Log
import com.dsm.cms.R
import com.dsm.cms.base.BaseActivity
import com.dsm.cms.databinding.ActivityPostBinding
import com.dsm.cms.viewModel.PostViewModel
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostActivity : BaseActivity<ActivityPostBinding>() {
    override val layoutResId: Int
        get() = R.layout.activity_post

    private var postId: Int = -1

    private val viewModel: PostViewModel by viewModel { parametersOf(postId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        postId = intent.getIntExtra("post_id", -1)

        Log.d("postId", "$postId")

        binding.viewModel = viewModel
    }
}