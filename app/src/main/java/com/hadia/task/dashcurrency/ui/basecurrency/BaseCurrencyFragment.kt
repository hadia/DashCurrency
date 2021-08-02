package com.hadia.task.dashcurrency.ui.basecurrency

import androidx.appcompat.app.AlertDialog
import com.hadia.task.dashcurrency.R
import com.hadia.task.dashcurrency.base.BaseBindingFragment
import com.hadia.task.dashcurrency.data.model.CryptoCurrencies
import com.hadia.task.dashcurrency.databinding.FragmentBaseCurrencyBinding
import com.hadia.task.dashcurrency.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BaseCurrencyFragment : BaseBindingFragment<FragmentBaseCurrencyBinding>() {
    override val viewModel: BaseCurrencyViewModel by viewModel()
    private val activityViewModel by sharedViewModel<MainViewModel>()
    override fun getLayoutResId(): Int = R.layout.fragment_base_currency

    override fun onViewBound(binding: FragmentBaseCurrencyBinding) {
        activityViewModel.currentCurrency.observe(
            viewLifecycleOwner,
            {
                binding.currencyValueTv.text = it.getCryptoCurrenciesName()
            }
        )
        binding.changeBtn.setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(requireContext()).apply {
            setTitle("Base Currency")
            val cryptoCurrenciesList = CryptoCurrencies.values().toList()
            setAdapter(
                CurrencyListAdapter(requireContext(), cryptoCurrenciesList)
            ) { dialog, which ->
                activityViewModel.changeCurrentCurrency(cryptoCurrenciesList[which])
                dialog.dismiss()
            }
        }.create()

        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.show()
    }
}
