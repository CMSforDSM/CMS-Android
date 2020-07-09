package com.dsm.cms.ui.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import com.dsm.cms.R
import com.dsm.cms.base.BaseActivity
import com.dsm.cms.databinding.ActivityLoginBinding
import com.dsm.cms.ext.hideKeyboard
import com.dsm.cms.ext.setupNavigateEvent
import com.dsm.cms.ext.setupToastEvent
import com.dsm.cms.viewModel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override val layoutResId: Int
        get() = R.layout.activity_login

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupToastEvent(viewModel.toastEvent)

        setupNavigate()

        viewModel.hideKeyEvent.observe(this, Observer { hideKeyboard() })
        viewModel.finishLoginEvent.observe(this, Observer { finish() })

        binding.viewModel = viewModel
    }

    private fun setupNavigate() {
        setupNavigateEvent<MainActivity>(viewModel.navigateMainEvent)
    }
}