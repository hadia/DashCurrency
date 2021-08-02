package com.hadia.task.dashcurrency.ui.basecurrency

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.hadia.task.dashcurrency.R
import com.hadia.task.dashcurrency.data.model.CryptoCurrencies
import com.hadia.task.dashcurrency.databinding.ItemAlertDialogBinding

class CurrencyListAdapter(
    context: Context,
    var items: List<CryptoCurrencies>
) :
    ArrayAdapter<CryptoCurrencies>(context, R.layout.item_alert_dialog, items) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemAlertDialogBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        binding.currencyTitleTv.text = items[position].getCryptoCurrenciesName()

        return binding.root
    }
}
