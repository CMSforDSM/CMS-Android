package com.dsm.cms.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.dsm.cms.ext.setupNavigateEvent
import com.dsm.cms.viewModel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.finishSplashEvent.observe(this, Observer { finish() })

        setupNavigate()
    }

    private fun setupNavigate() {
        setupNavigateEvent<MainActivity>(viewModel.navigateMainEvent)
        setupNavigateEvent<LoginActivity>(viewModel.navigateLoginEvent)
    }
}