package com.dsm.cms.ui.fragment

import android.os.Bundle
import android.view.View
import com.dsm.cms.R
import com.dsm.cms.base.BaseFragment
import com.dsm.cms.databinding.FragmentMainBinding
import com.dsm.cms.ui.adapter.ClubAdapter
import com.dsm.cms.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val layoutResId: Int
        get() = R.layout.fragment_main

    private val viewModel: MainViewModel by sharedViewModel()

    private val clubsAdapter by lazy { ClubAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        binding.viewModel = viewModel
    }

    private fun setUpRecyclerView() {
        binding.rvMain.adapter = clubsAdapter
        binding.rvMain.setHasFixedSize(true)
    }
}