package com.donank.tradecrypto.Api

import android.util.Log
import com.donank.tradecrypto.Data.*
import com.donank.tradecrypto.Data.AppPref.bittrexApiKey
import com.donank.tradecrypto.Data.Exchanges.*
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ApiHelper {

    @Inject lateinit var bitrexApiService: BittrexApiService

    fun getTickerPrice(market: String, exchange: Exchanges) {

        when (exchange) {
            BITTREX -> {
                bitrexApiService.getTicker(market)
                        .subscribeOn(Schedulers.newThread())
                        .map {
                            if (it.success) {
                                return@map it.result
                            } else Log.d("$exchange: getTicker($market) failed", "${it.message}")
                        }
            }
        }
    }

    fun getOrderBook(market: String, exchange: Exchanges, type: OrderBookType) {

        when (exchange) {
            BITTREX -> {
                bitrexApiService.getOrderBook(market, type.toString().toLowerCase())
                        .map {
                            if (it.success) {
                                return@map it.result
                            } else Log.d("$exchange: getOrderBook($market) failed", "${it.message}")
                        }

            }
        }
    }

    fun buy(market: String, exchange: Exchanges, quantity: Double, rate: Double) {

        when (exchange) {
            BITTREX -> {
                bitrexApiService.buy(bittrexApiKey, market, quantity, rate)
                        .map {
                            if (it.success) {
                                return@map it.result
                            } else Log.d("$exchange: buy($market - $quantity|$rate) failed", "${it.message}")
                        }
            }
        }
    }

    fun sell(market: String, exchange: Exchanges, quantity: Double, rate: Double) {

        when (exchange) {
            BITTREX -> {
                bitrexApiService.sell(bittrexApiKey, market, quantity, rate)
                        .map {
                            if (it.success) {
                                return@map it.result
                            } else Log.d("$exchange: sell($market - $quantity|$rate) failed", "${it.message}")
                        }
            }
        }
    }

    fun cancel(market: String, exchange: Exchanges, uuid : String) {

        when (exchange) {
            BITTREX -> {
                bitrexApiService.cancel(bittrexApiKey, uuid)
                        .map {
                            if (it.success) {
                                return@map it.result
                            } else Log.d("$exchange: cancel($uuid) failed", "${it.message}")
                        }
            }
        }
    }
}