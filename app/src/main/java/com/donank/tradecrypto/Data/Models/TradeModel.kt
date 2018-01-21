package com.donank.tradecrypto.Data.Models

data class TickerValueModel(
        var bid: Double? = null,
        var ask: Double? = null,
        var last: Double? = null
)

data class OrderBookModel(
        var quantity : Double? = null,
        var rate : Double? = null
)

data class TradeResultModel(
        var uuid : String? = null
)