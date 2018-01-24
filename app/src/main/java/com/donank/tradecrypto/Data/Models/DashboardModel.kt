package com.donank.tradecrypto.Data.Models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

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
        var exchange : Exchanges? = null,
        var percentChange : Float? = null
)

enum class Action {
        BUYLIMIT, SELLLIMIT, TRANSFER, ALERT
}

@Entity(tableName = "tracked_currency")
data class TrackedCurrency (

    @ColumnInfo(name = "ticker")
    var ticker : String? = null,
    @ColumnInfo(name = "exchange")
    var exchange : String? = null,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
)




