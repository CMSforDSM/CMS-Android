package com.dsm.cms.di

import com.dsm.cms.data.datasource.*
import org.koin.dsl.module

val dataSourceModule = module {

    factory<RemoteAuthDataSource> { RemoteAuthDataSourceImpl(get()) }

    factory<RemoteStudentDataSource> { RemoteStudentDataSourceImpl(get()) }

    factory<RemoteClubDataSource> { RemoteClubDataSourceImpl(get()) }

    factory<RemotePostDataSource> { RemotePostDataSourceImpl(get()) }
}