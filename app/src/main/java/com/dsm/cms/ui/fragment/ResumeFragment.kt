package com.dsm.cms.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dsm.cms.R
import com.dsm.cms.base.BaseFragment
import com.dsm.cms.databinding.FragmentResumeBinding
import com.dsm.cms.ui.adapter.MainResumeAdapter
import com.dsm.cms.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ResumeFragment : BaseFragment<FragmentResumeBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_resume

    private val viewModel: MainViewModel by sharedViewModel()

    private val resumeAdapter by lazy { MainResumeAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        binding.viewModel = viewModel
    }

    private fun setUpRecyclerView() {
        binding.rvResume.adapter = resumeAdapter
        binding.rvResume.setHasFixedSize(true)
    }
}