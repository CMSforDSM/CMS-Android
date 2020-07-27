package com.dsm.cms.ui.activity

import android.os.Bundle
import com.dsm.cms.R
import com.dsm.cms.base.BaseActivity
import com.dsm.cms.databinding.ActivityPostBinding
import com.dsm.cms.domain.entity.Post
import com.dsm.cms.viewModel.PostViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PostActivity : BaseActivity<ActivityPostBinding>() {
    override val layoutResId: Int
        get() = R.layout.activity_post

    private lateinit var post: Post

    private val viewModel: PostViewModel by viewModel { parametersOf(post) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        post = intent.getSerializableExtra("post") as Post

        binding.viewModel = viewModel

        binding.toolbarPost.setNavigationOnClickListener {
            finish()
        }
    }
}