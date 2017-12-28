package com.donank.tradecrypto.Data

/**
 * Created by donank on 28/12/17.
 */

data class Market(
        val success : Boolean? = null,
        val message : String? = null,
        val result : List<MarketResult>? = null
)

data class MarketResult (
    var marketCurrency: String? = null,
    var baseCurrency: String? = null,
    var marketCurrencyLong: String? = null,
    var baseCurrencyLong: String? = null,
    var minTradeSize: Double? = null,
    var marketName: String? = null,
    var isActive: Boolean? = null,
    var created: String? = null,
    var notice: Any? = null,
    var isSponsored: Any? = null,
    var logoUrl: String? = null
)

data class SupportedCurrencies (
    var success: Boolean? = null,
    var message: String? = null,
    var result: List<SupportedCurrenciesResult>? = null
)

data class SupportedCurrenciesResult(
        var currency: String? = null,
        var currencyLong: String? = null,
        var minConfirmation: Int? = null,
        var txFee: Double? = null,
        var isActive: Boolean? = null,
        var coinType: String? = null,
        var baseAddress: Any? = null
)


data class TickerValues (
        var success: Boolean? = null,
        var message: String? = null,
        var result: TickerValuesResult? = null
)

data class TickerValuesResult (
        var bid: Double? = null,
        var ask: Double? = null,
        var last: Double? = null
)


