package com.hadia.task.dashcurrency.data.repository

import com.hadia.task.dashcurrency.data.endpoint.ExchangeRateEndPoint

class ExchangeRateRepository(private val exchangeRateEndPoint: ExchangeRateEndPoint) {
    suspend fun getExchangeRates(currency: String) = exchangeRateEndPoint.getExchangeRates(currency)
}
