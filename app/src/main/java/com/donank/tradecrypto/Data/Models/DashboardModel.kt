package com.donank.tradecrypto.Data.Models

import android.arch.persistence.room.*

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

@Entity(tableName = "dashboard_model")
data class DashboardModel (
        @ColumnInfo(name = "currency")
        var currency : String? = null,
        @ColumnInfo(name = "price")
        var price : Double? = null,
        @ColumnInfo(name = "amount")
        var amount : Double? = null,
        @ColumnInfo(name = "change")
        var change : Double? = null,
        @ColumnInfo(name = "action")
        @TypeConverters(ActionConverter::class)
        var action : Action? = null,
        @ColumnInfo(name = "exchange")
        @TypeConverters(ExchangeConverter::class)
        var exchange : Exchanges? = null,
        @ColumnInfo(name = "percent_change")
        var percentChange : Float? = null,
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0
)

@Entity(tableName = "tracked_currency")
data class TrackedCurrency (
        @ColumnInfo(name = "ticker")
        var ticker: String? = null,
        @ColumnInfo(name = "exchange")
        var exchange: String? = null,
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0
)

class ExchangeConverter {
        @TypeConverter
        fun exchangeToString(exchange: Exchanges?): String {
                when(exchange){
                        Exchanges.BITTREX -> return "bittrex"
                        Exchanges.POLONIEX -> return "poloniex"
                        Exchanges.BINANCE -> return "binance"
                        Exchanges.RADAR -> return "radar"
                }
                return "no-exchange"
        }

        @TypeConverter
        fun stringToExchange(value : String?) : Exchanges {
                when(value){
                        "bittrex" -> return Exchanges.BITTREX
                        "poloniex" -> return Exchanges.POLONIEX
                        "binance" -> return Exchanges.BINANCE
                        "radar" -> return Exchanges.RADAR
                        "no-exchange" -> return Exchanges.NO_EXCHANGE
                }
                return Exchanges.NO_EXCHANGE
        }
}

class ActionConverter {
        @TypeConverter
        fun actionToString(action: Action?): String {
               when(action){
                       Action.BUYLIMIT -> return "buy-limit"
                       Action.SELLLIMIT -> return "sell-limit"
                       Action.TRANSFER -> return "transfer"
                       Action.ALERT -> return "alert"
               }
                return "no_ction"
        }

        @TypeConverter
        fun stringToAction(value: String?): Action {
                when(value){
                        "buy-limit" -> return Action.BUYLIMIT
                        "sell-limit" -> return Action.SELLLIMIT
                        "transfer" -> return  Action.TRANSFER
                        "alert" -> return Action.ALERT
                        "no_action" -> return Action.NO_ACTION
                }
                return Action.NO_ACTION
        }
}




