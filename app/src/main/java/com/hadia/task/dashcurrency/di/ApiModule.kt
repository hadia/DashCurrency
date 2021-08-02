package com.hadia.task.dashcurrency.di

import com.hadia.task.dashcurrency.data.endpoint.ExchangeRateEndPoint
import com.hadia.task.dashcurrency.network.RetrofitClient
import org.koin.dsl.module

val apiModule = module {
    single { get<RetrofitClient>().create(ExchangeRateEndPoint::class.java) }
}
