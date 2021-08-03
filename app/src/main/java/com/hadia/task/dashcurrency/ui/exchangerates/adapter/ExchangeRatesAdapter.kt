package com.hadia.task.dashcurrency.ui.exchangerates.adapter

import com.hadia.task.dashcurrency.R
import com.hadia.task.dashcurrency.base.BaseAdapter
import com.hadia.task.dashcurrency.databinding.ItemExchangeRateBinding

class ExchangeRatesAdapter : BaseAdapter<ExchangeRateUiModel, ItemExchangeRateBinding >() {
    override fun getLayoutResId(): Int = R.layout.item_exchange_rate

    override fun bind(binding: ItemExchangeRateBinding, item: ExchangeRateUiModel, position: Int) {
        binding.viewModel = item
    }
}
