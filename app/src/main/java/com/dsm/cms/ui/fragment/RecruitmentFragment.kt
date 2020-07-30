package com.dsm.cms.ui.fragment

import android.os.Bundle
import android.view.View
import com.dsm.cms.R
import com.dsm.cms.base.BaseFragment
import com.dsm.cms.databinding.FragmentRecruitmentBinding
import com.dsm.cms.ui.adapter.PostAdapter
import com.dsm.cms.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class RecruitmentFragment : BaseFragment<FragmentRecruitmentBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_recruitment

    private val viewModel: MainViewModel by sharedViewModel()

    private val postAdapter by lazy { PostAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        binding.viewModel = viewModel

        binding.swipeRecruitment.setOnRefreshListener {
            viewModel.getPosts("RECRUITMENT")

            postAdapter.notifyDataSetChanged()

            binding.swipeRecruitment.isRefreshing = false
        }
    }


    private fun setUpRecyclerView() {
        binding.rvRecruitment.adapter = postAdapter
        binding.rvRecruitment.setHasFixedSize(true)
    }
}