package com.dsm.cms.ui.fragment

import android.os.Bundle
import android.view.View
import com.dsm.cms.R
import com.dsm.cms.base.BaseFragment
import com.dsm.cms.databinding.FragmentRecruitmentBinding
import com.dsm.cms.ui.adapter.MainRecruitmentAdapter
import com.dsm.cms.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class RecruitmentFragment : BaseFragment<FragmentRecruitmentBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_recruitment

    private val viewModel: MainViewModel by sharedViewModel()

    private val recruitmentAdapter by lazy { MainRecruitmentAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        binding.viewModel = viewModel
    }


    private fun setUpRecyclerView() {
        binding.rvRecruitment.adapter = recruitmentAdapter
        binding.rvRecruitment.setHasFixedSize(true)
    }
}