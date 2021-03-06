package com.dsm.cms.ui.activity

import android.os.Bundle
import com.dsm.cms.R
import com.dsm.cms.base.BaseActivity
import com.dsm.cms.databinding.ActivityClubBinding
import com.dsm.cms.domain.entity.Club
import com.dsm.cms.ext.setupToastEvent
import com.dsm.cms.ui.adapter.MemberAdapter
import com.dsm.cms.ui.adapter.PostAdapter
import com.dsm.cms.viewModel.ClubViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class ClubActivity : BaseActivity<ActivityClubBinding>() {
    override val layoutResId: Int
        get() = R.layout.activity_club

    private lateinit var club: Club

    private val memberAdapter by lazy { MemberAdapter() }

    private val postAdapter by lazy { PostAdapter() }

    private val viewModel: ClubViewModel by viewModel { parametersOf(club) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        club = intent.getSerializableExtra("club") as Club

        setUpRecyclerView()
        setBtnClickListener()

        binding.viewModel = viewModel

        setupToastEvent(viewModel.toastEvent)

        binding.swipeClub.setOnRefreshListener {
            viewModel.getClubsPosts()

            postAdapter.notifyDataSetChanged()

            binding.swipeClub.isRefreshing = false
        }

        binding.toolbarClub.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setBtnClickListener() {
        binding.includeClubDetailClub.btnItem.apply {
            setOnClickListener {
                if (this.text == getString(R.string.apply_club)) viewModel.applyClub()
            }
        }
    }

    private fun setUpRecyclerView() {
        binding.rvMember.adapter = memberAdapter
        binding.rvMember.setHasFixedSize(true)

        binding.rvPostClub.adapter = postAdapter
        binding.rvPostClub.setHasFixedSize(true)
    }
}