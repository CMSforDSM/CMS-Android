package com.dsm.cms.ui.activity

import android.os.Bundle
import com.dsm.cms.R
import com.dsm.cms.base.BaseActivity
import com.dsm.cms.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override val layoutResId: Int
        get() = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}