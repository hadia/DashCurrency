package com.hadia.task.dashcurrency.di

import com.hadia.task.dashcurrency.ui.MainViewModel
import com.hadia.task.dashcurrency.ui.basecurrency.BaseCurrencyViewModel
import com.hadia.task.dashcurrency.ui.exchangerates.ExchangeRatesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { BaseCurrencyViewModel() }
    viewModel { ExchangeRatesViewModel(get()) }
}
