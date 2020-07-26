package com.dsm.cms.di

import com.dsm.cms.viewModel.LoginViewModel
import com.dsm.cms.viewModel.MainViewModel
import com.dsm.cms.viewModel.PostViewModel
import com.dsm.cms.viewModel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get(), get()) }

    viewModel { SplashViewModel(get()) }

    viewModel { MainViewModel(get(), get(), get()) }

    viewModel { (postId: Int) -> PostViewModel(postId) }
}