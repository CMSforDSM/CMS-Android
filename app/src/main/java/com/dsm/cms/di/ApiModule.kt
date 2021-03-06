package com.dsm.cms.di

import com.dsm.cms.data.api.CmsApi
import com.dsm.cms.data.api.TokenApi
import com.dsm.cms.data.interceptor.TokenInterceptor
import com.dsm.cms.data.pref.PrefStorage
import com.dsm.cms.data.pref.PrefStorageImpl
import com.dsm.cms.error.ErrorHandler
import com.dsm.cms.error.ErrorHandlerImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val baseURL = "http://3.34.0.219:5000/"

val apiModule = module {

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(TokenApi::class.java)
    }

    single {
        Retrofit.Builder()
            .baseUrl(baseURL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(TokenInterceptor(get(), get()))
                    .addInterceptor(get<HttpLoggingInterceptor>())
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CmsApi::class.java)
    }

    single<PrefStorage> { PrefStorageImpl(get()) }

    single<ErrorHandler> { ErrorHandlerImpl() }

}