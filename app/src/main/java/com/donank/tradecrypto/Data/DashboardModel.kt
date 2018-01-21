package com.donank.tradecrypto.Data

import java.util.*

/**
 * Created by xterra on 31/12/17.
 */

data class KeyPair (
        val name : Exchanges? = null,
        val apiKey : String? = null
)

enum class Exchanges {
        BITTREX, POLONIEX, BINANCE, RADAR
}

enum class OrderBookType {
       BUY, SELL, BOTH
}

data class CMCModel(
        var symbol : String,
        var price_usd : String,
        var price_btc : String,
        var percent_change_1h : String,
        var percent_change_24h : String,
        var percent_change_7d : String
)


data class DashboardModel (
        var currency : String? = null,
        var price : Double? = null,
        var amount : Double? = null,
        var change : Double? = null,
        var action : Action? = null,
        var exchange : Exchanges? = null
)

enum class Action {
        BUYLIMIT, SELLLIMIT, TRANSFER, ALERT
}

data class TrackedCurrencies (
    val ticker : String? = null,
    val exchange : Exchanges? = null
)




