package com.donank.tradecrypto.Data

import android.arch.persistence.room.TypeConverter
import com.donank.tradecrypto.Data.Models.Action
import com.donank.tradecrypto.Data.Models.Exchanges

class Converter {
    @TypeConverter
    fun exchangeToString(exchange: Exchanges?): String {
        when (exchange) {
            Exchanges.NO_EXCHANGE -> return "no-exchange"
            Exchanges.BITTREX -> return "bittrex"
            Exchanges.POLONIEX -> return "poloniex"
            Exchanges.BINANCE -> return "binance"
            Exchanges.RADAR -> return "radar"
        }
        return "no-exchange"
    }

    @TypeConverter
    fun stringToExchange(value: String?): Exchanges {
        when (value) {
            "bittrex" -> return Exchanges.BITTREX
            "poloniex" -> return Exchanges.POLONIEX
            "binance" -> return Exchanges.BINANCE
            "radar" -> return Exchanges.RADAR
            "no-exchange" -> return Exchanges.NO_EXCHANGE
        }
        return Exchanges.NO_EXCHANGE
    }

    @TypeConverter
    fun actionToString(action: Action?): String {
        when (action) {
            Action.BUYLIMIT -> return "buy-limit"
            Action.SELLLIMIT -> return "sell-limit"
            Action.TRANSFER -> return "transfer"
            Action.ALERT -> return "alert"
            Action.NO_ACTION -> return "no-action"
        }
        return "no_action"
    }

    @TypeConverter
    fun stringToAction(value: String?): Action {
        when (value) {
            "buy-limit" -> return Action.BUYLIMIT
            "sell-limit" -> return Action.SELLLIMIT
            "transfer" -> return Action.TRANSFER
            "alert" -> return Action.ALERT
            "no_action" -> return Action.NO_ACTION
        }
        return Action.NO_ACTION
    }
}

