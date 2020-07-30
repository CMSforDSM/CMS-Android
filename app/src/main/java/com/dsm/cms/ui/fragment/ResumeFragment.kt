package com.dsm.cms.ui.fragment

import android.os.Bundle
import android.view.View
import com.dsm.cms.R
import com.dsm.cms.base.BaseFragment
import com.dsm.cms.databinding.FragmentResumeBinding
import com.dsm.cms.ui.adapter.ResumeAdapter
import com.dsm.cms.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ResumeFragment : BaseFragment<FragmentResumeBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_resume

    private val viewModel: MainViewModel by sharedViewModel()

    private val resumeAdapter by lazy { ResumeAdapter(viewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

        setUpRecyclerView()

        binding.swipeResume.setOnRefreshListener {
            viewModel.getPosts("RESUME")

            resumeAdapter.notifyDataSetChanged()

            binding.swipeResume.isRefreshing = false;
        }
    }

    private fun setUpRecyclerView() {
        binding.rvResume.adapter = resumeAdapter
        binding.rvResume.setHasFixedSize(true)
    }
}