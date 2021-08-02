package com.hadia.task.dashcurrency.data.model

enum class CryptoCurrencies(val code: String, val currencyName: String) {
    BITCOIN("BTC", "Bitcoin"),
    BITCOIN_CASH("BCH", "Bitcoin Cash"),
    ETHER("ETH", "Ether"),
    RIPPLE("XRP", "Ripple"),
    DOGECOIN("DOGE", "Dogecoin");

    fun getCryptoCurrenciesName(): String {
        return "${this.currencyName} (${this.code})"
    }
}
