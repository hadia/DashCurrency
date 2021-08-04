package com.hadia.task.dashcurrency.data.model

import android.util.ArrayMap
import com.google.gson.annotations.SerializedName

data class ExchangeRatesResponse(
    @SerializedName("data")
    val data: ExchangeRatesData
)

data class ExchangeRatesData(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("rates")
    val rates: androidx.collection.ArrayMap<String, String>
)
