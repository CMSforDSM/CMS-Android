package com.dsm.cms.di

import com.dsm.cms.data.datasource.RemoteAuthDataSource
import com.dsm.cms.data.datasource.RemoteAuthDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    factory<RemoteAuthDataSource> { RemoteAuthDataSourceImpl(get()) }
}