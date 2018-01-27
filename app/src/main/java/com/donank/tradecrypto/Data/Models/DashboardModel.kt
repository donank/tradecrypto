package com.donank.tradecrypto.Data.Models


/**
 * Created by donank on 31/12/17.
 */

data class KeyPair (
        val name : Exchanges? = null,
        val apiKey : String? = null
)

enum class Exchanges {
        BITTREX, POLONIEX, BINANCE, RADAR, NO_EXCHANGE
}

enum class Action {
        BUYLIMIT, SELLLIMIT, TRANSFER, ALERT, NO_ACTION
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

data class CoinCapModel (
        var market_cap : List<Pair<Long, Long>>,
        var price : List<Pair<Long, Double>>,
        var volume : List<Pair<Long, Long>>
)

data class DashboardModel (
        var currency : String? = null,
        var price : Double? = null,
        var dayHigh : Double,
        var dayLow : Double,
        var change : Double? = null,
        var exchange : Exchanges? = null,
        var percentChange : Float? = null
)







