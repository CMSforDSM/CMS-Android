package com.dsm.cms.ui.activity

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.dsm.cms.R
import com.dsm.cms.base.BaseActivity
import com.dsm.cms.databinding.ActivityMainBinding
import com.dsm.cms.ext.setupToastEvent
import com.dsm.cms.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutResId: Int
        get() = R.layout.activity_main

    private val viewModel: MainViewModel by viewModel()

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        setupToastEvent(viewModel.toastEvent)

        navController = findNavController(R.id.frag_main)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_main_fragment,
                R.id.nav_announcement_fragment,
                R.id.nav_market_fragment,
                R.id.nav_notice_fragment
            ), binding.drawerLayoutMain
        )

        binding.navigationMain.setupWithNavController(navController)
        binding.toolbarMain.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onBackPressed() {
        if (binding.drawerLayoutMain.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
        } else if (appBarConfiguration.topLevelDestinations.contains(navController.currentDestination?.id)) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}
