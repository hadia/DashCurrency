package com.hadia.task.dashcurrency.ui.exchangerates

import androidx.lifecycle.viewModelScope
import com.hadia.task.dashcurrency.base.BaseViewModel
import com.hadia.task.dashcurrency.data.model.CryptoCurrencies
import com.hadia.task.dashcurrency.data.repository.ExchangeRateRepository
import kotlinx.coroutines.launch

class ExchangeRatesViewModel(private val exchangeRateRepository: ExchangeRateRepository) : BaseViewModel() {
    fun loadExchangeRateList(cryptoCurrencies: CryptoCurrencies) {
        viewModelScope.launch {
            val exchangeRatesDataList =
                exchangeRateRepository.getExchangeRates(cryptoCurrencies.code)
        }
    }
}
