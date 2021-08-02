package com.hadia.task.dashcurrency.ui

import androidx.lifecycle.MutableLiveData
import com.hadia.task.dashcurrency.base.BaseViewModel
import com.hadia.task.dashcurrency.data.model.CryptoCurrencies

class MainViewModel : BaseViewModel() {
    var currentCurrency = MutableLiveData<CryptoCurrencies>()
    init {
        currentCurrency.value = CryptoCurrencies.BITCOIN
    }
    fun changeCurrentCurrency(selectedCurrency: CryptoCurrencies) {
        this.currentCurrency.value = selectedCurrency
    }
}
