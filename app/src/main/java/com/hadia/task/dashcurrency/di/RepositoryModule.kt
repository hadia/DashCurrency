package com.hadia.task.dashcurrency.di

import com.hadia.task.dashcurrency.data.repository.ExchangeRateRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { ExchangeRateRepository(get()) }
}
