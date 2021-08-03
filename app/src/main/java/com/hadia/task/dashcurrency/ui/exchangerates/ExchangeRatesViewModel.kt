package com.hadia.task.dashcurrency.ui.exchangerates

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hadia.task.dashcurrency.base.BaseViewModel
import com.hadia.task.dashcurrency.data.model.CryptoCurrencies
import com.hadia.task.dashcurrency.data.repository.ExchangeRateRepository
import com.hadia.task.dashcurrency.extension.toFormattedNumberString
import com.hadia.task.dashcurrency.ui.exchangerates.adapter.ExchangeRateUiModel
import kotlinx.coroutines.launch

class ExchangeRatesViewModel(private val exchangeRateRepository: ExchangeRateRepository) : BaseViewModel() {
    private val _exchangeRatesDataList = MutableLiveData<List<ExchangeRateUiModel>>()

    val exchangeRatesDataList: LiveData<List<ExchangeRateUiModel>>
        get() = _exchangeRatesDataList

    fun loadExchangeRateList(cryptoCurrencies: CryptoCurrencies) {
        viewModelScope.launch {
            _exchangeRatesDataList.value =
                exchangeRateRepository.getExchangeRates(cryptoCurrencies.code).body()?.data?.rates?.mapNotNull {
                    ExchangeRateUiModel(it.key, it.value.toFormattedNumberString())
                }
        }
    }
}
