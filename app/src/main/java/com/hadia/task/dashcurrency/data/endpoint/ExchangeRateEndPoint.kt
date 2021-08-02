package com.hadia.task.dashcurrency.data.endpoint

import com.hadia.task.dashcurrency.data.model.ExchangeRatesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeRateEndPoint {
    @GET("v2/exchange-rates")
    suspend fun getExchangeRates(@Query("currency") currency: String): Response<ExchangeRatesResponse>
}
