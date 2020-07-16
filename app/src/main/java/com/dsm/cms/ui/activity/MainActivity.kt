package com.dsm.cms.ui.activity

import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import com.dsm.cms.R
import com.dsm.cms.base.BaseActivity
import com.dsm.cms.databinding.ActivityMainBinding
import com.dsm.cms.viewModel.MainViewModel
import kotlinx.android.synthetic.main.item_club.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutResId: Int
        get() = R.layout.activity_main

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        setNavigationDrawer()
    }

    private fun setNavigationDrawer() {
        binding.toolbarMain.setNavigationOnClickListener {
            binding.drawerLayoutMain.openDrawer(GravityCompat.START)
        }
    }

    override fun onBackPressed() {
        if (binding.drawerLayoutMain.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
