package com.dsm.cms.ui.fragment

import android.os.Bundle
import android.view.View
import com.dsm.cms.R
import com.dsm.cms.base.BaseFragment
import com.dsm.cms.databinding.FragmentNoticeBinding
import com.dsm.cms.ui.adapter.MainPostAdapter
import com.dsm.cms.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class NoticeFragment : BaseFragment<FragmentNoticeBinding>() {
    override val layoutResId: Int
        get() = R.layout.fragment_notice

    private val viewModel: MainViewModel by sharedViewModel()

    private val postAdapter by lazy { MainPostAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        binding.viewModel = viewModel
    }

    private fun setUpRecyclerView() {
        binding.rvNotices.adapter = postAdapter
        binding.rvNotices.setHasFixedSize(true)
    }
}