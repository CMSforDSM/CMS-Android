package com.dsm.cms

import android.app.Application
import com.dsm.cms.di.apiModule
import com.dsm.cms.di.dataSourceModule
import com.dsm.cms.di.repositoryModule
import com.dsm.cms.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    dataSourceModule,
                    repositoryModule,
                    viewModelModule,
                    apiModule
                )
            )
        }
    }
}