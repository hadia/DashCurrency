package com.hadia.task.dashcurrency.di

import com.hadia.task.dashcurrency.BuildConfig
import com.hadia.task.dashcurrency.network.HeadersInterceptor
import com.hadia.task.dashcurrency.network.RetrofitClient
import org.koin.dsl.module

val networkModule = module {
    single {
        RetrofitClient.Builder(BuildConfig.BASE_URL)
            .build {
                useDefaultLoggerInterceptor()
                addInterceptor(HeadersInterceptor())
            }
    }
}
