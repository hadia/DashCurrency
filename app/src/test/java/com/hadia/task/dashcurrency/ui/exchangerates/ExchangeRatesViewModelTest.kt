package com.hadia.task.dashcurrency.ui.exchangerates

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.collection.arrayMapOf
import androidx.lifecycle.Observer
import com.hadia.task.dashcurrency.TestCoroutineRule
import com.hadia.task.dashcurrency.data.model.CryptoCurrencies
import com.hadia.task.dashcurrency.data.model.ExchangeRatesData
import com.hadia.task.dashcurrency.data.model.ExchangeRatesResponse
import com.hadia.task.dashcurrency.data.repository.ExchangeRateRepository
import com.hadia.task.dashcurrency.network.Resource
import com.hadia.task.dashcurrency.ui.exchangerates.adapter.ExchangeRateUiModel
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ExchangeRatesViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var exchangeRateRepository: ExchangeRateRepository
    private val validCryptoCurrencies = CryptoCurrencies.BITCOIN.code
    private val successResponse = Resource.success(
        ExchangeRatesResponse(
            ExchangeRatesData(
                validCryptoCurrencies,
                arrayMapOf(Pair("AOA", "344685.649385"), Pair("ARS", "352253.239183"))
            )
        )
    )

    @Mock
    private lateinit var exchangeRateObserver: Observer<List<ExchangeRateUiModel>>

    @ExperimentalCoroutinesApi
    @ObsoleteCoroutinesApi
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `when loadExchangeRateList is called with valid Currency, then observer is updated with success`() {
        testCoroutineRule.runBlockingTest {
            whenever(exchangeRateRepository.getExchangeRates(validCryptoCurrencies)).thenReturn(successResponse)

            val viewModel = ExchangeRatesViewModel(exchangeRateRepository)
            viewModel.exchangeRatesDataList.observeForever(exchangeRateObserver)
            viewModel.loadExchangeRateList(CryptoCurrencies.BITCOIN)

            verify(exchangeRateObserver).onChanged(
                listOf(
                    ExchangeRateUiModel("AOA", "344685.65"), ExchangeRateUiModel("ARS", "352253.24")
                )
            )
            viewModel.exchangeRatesDataList.removeObserver(exchangeRateObserver)
        }
    }
}
