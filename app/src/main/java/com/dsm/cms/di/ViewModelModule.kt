package com.dsm.cms.di

import com.dsm.cms.domain.entity.Club
import com.dsm.cms.domain.entity.Post
import com.dsm.cms.viewModel.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get(), get()) }

    viewModel { SplashViewModel(get()) }

    viewModel { MainViewModel(get(), get(), get()) }

    viewModel { (post: Post) -> PostViewModel(post, get()) }

    viewModel { (club: Club) -> ClubViewModel(club, get(), get(), get()) }
}