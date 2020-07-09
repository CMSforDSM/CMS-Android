package com.dsm.cms.di

import com.dsm.cms.data.repository.AuthRepositoryImpl
import com.dsm.cms.domain.repository.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<AuthRepository> { AuthRepositoryImpl(get(), get()) }
}