package com.dsm.cms.di

import com.dsm.cms.data.repository.AuthRepositoryImpl
import com.dsm.cms.data.repository.ClubRepositoryImpl
import com.dsm.cms.data.repository.StudentRepositoryImpl
import com.dsm.cms.domain.repository.AuthRepository
import com.dsm.cms.domain.repository.ClubRepository
import com.dsm.cms.domain.repository.StudentRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    factory<StudentRepository> { StudentRepositoryImpl(get(), get()) }
    factory<ClubRepository> { ClubRepositoryImpl(get()) }
}