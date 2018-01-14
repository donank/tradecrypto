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
        val currency : String? = null,
        val price : Double? = null,
        val amount : Double? = null,
        val change : Double? = null,
        val action : Action? = null
)

enum class Action {
        BUYLIMIT, SELLLIMIT, TRANSFER, ALERT
}




