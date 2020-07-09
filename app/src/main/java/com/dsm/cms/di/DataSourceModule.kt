package com.dsm.cms.di

import com.dsm.cms.data.datasource.RemoteAuthDataSource
import com.dsm.cms.data.datasource.RemoteAuthDataSourceImpl
import com.dsm.cms.data.datasource.RemoteStudentDataSource
import com.dsm.cms.data.datasource.RemoteStudentDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    factory<RemoteAuthDataSource> { RemoteAuthDataSourceImpl(get()) }
    factory<RemoteStudentDataSource> { RemoteStudentDataSourceImpl(get()) }
}