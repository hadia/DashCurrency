package com.hadia.task.dashcurrency.data.repository

import com.hadia.task.dashcurrency.base.BaseRepository
import com.hadia.task.dashcurrency.data.endpoint.ExchangeRateEndPoint

class ExchangeRateRepository(private val exchangeRateEndPoint: ExchangeRateEndPoint) :
    BaseRepository() {
    suspend fun getExchangeRates(currency: String) = getResult { exchangeRateEndPoint.getExchangeRates(currency) }
}
