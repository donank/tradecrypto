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
        BITTREX, POLONIEX
}

enum class OrderBookType {
       BUY, SELL, BOTH
}


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




