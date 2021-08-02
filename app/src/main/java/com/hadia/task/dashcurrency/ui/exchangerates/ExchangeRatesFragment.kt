package com.hadia.task.dashcurrency.ui.exchangerates

import com.hadia.task.dashcurrency.R
import com.hadia.task.dashcurrency.base.BaseBindingFragment
import com.hadia.task.dashcurrency.databinding.FragmentExchangeRatesBinding
import com.hadia.task.dashcurrency.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExchangeRatesFragment : BaseBindingFragment<FragmentExchangeRatesBinding>() {
    override val viewModel: ExchangeRatesViewModel by viewModel()
    private val activityViewModel by sharedViewModel<MainViewModel>()
    override fun getLayoutResId(): Int = R.layout.fragment_exchange_rates

    override fun onViewBound(binding: FragmentExchangeRatesBinding) {
        activityViewModel.currentCurrency.observe(
            viewLifecycleOwner,
            {
                viewModel.loadExchangeRateList(it)
            }
        )
    }
}
