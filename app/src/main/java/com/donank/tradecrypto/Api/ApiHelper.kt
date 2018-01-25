package com.donank.tradecrypto.Api

import android.util.Log
import com.donank.tradecrypto.Api.REST.BittrexRESTInterface
import com.donank.tradecrypto.Api.REST.PoloniexRESTInterface
import com.donank.tradecrypto.Data.AppPref.bittrexApiKey
import com.donank.tradecrypto.Data.Models.DashboardModel
import com.donank.tradecrypto.Data.Models.Exchanges
import com.donank.tradecrypto.Data.Models.Exchanges.*
import com.donank.tradecrypto.Data.Models.OrderBookType
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import javax.inject.Inject

class ApiHelper constructor(val bittrexRESTInterface: BittrexRESTInterface, val poloniexRESTInterface: PoloniexRESTInterface){

    fun getTickerPrice(market: String?, exchange: String?): DashboardModel {
        val dashModel = DashboardModel()
        Log.d("getTickerPrice", "$market | $exchange")
        when (exchange) {
            "BITTREX" -> {
                Log.d("Inside ", "BITTREX")
                runBlocking {
                    bittrexRESTInterface.getTicker(market!!)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .map {
                                if (it.success) {
                                    dashModel.price = it.result!!.Last
                                    dashModel.currency = market
                                    dashModel.exchange = BITTREX
                                    return@map dashModel
                                } else Log.d("$exchange: getTicker($market) failed", "${it.message}")
                            }
                }

            }
            "POLONIEX" ->  {
                Log.d("Inside ", "POLONIEX")
                runBlocking {
                    poloniexRESTInterface.getTicker()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .map {
                                if (!it.isEmpty()) {
                                    it.forEach {
                                        if (it.key == market) {
                                            dashModel.price = it.value.last.toDouble()
                                            dashModel.currency = market
                                            dashModel.exchange = POLONIEX
                                            dashModel.percentChange = it.value.percentChange.toFloat()
                                            return@map dashModel
                                        }
                                    }
                                } else Log.d("POLONIEX ", "Request Failed")
                            }
                }

            }
        }
        Log.d("getTickerPrice - return", "$dashModel")
        return dashModel
    }
/*
    fun getOrderBook(market: String, exchange: Exchanges, type: OrderBookType) {

        when (exchange) {
            BITTREX -> {
                bittrexRESTInterface.getOrderBook(market, type.toString().toLowerCase())
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
                bittrexRESTInterface.buy(bittrexApiKey, market, quantity, rate)
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
                bittrexRESTInterface.sell(bittrexApiKey, market, quantity, rate)
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
                bittrexRESTInterface.cancel(bittrexApiKey, uuid)
                        .map {
                            if (it.success) {
                                return@map it.result
                            } else Log.d("$exchange: cancel($uuid) failed", "${it.message}")
                        }
            }
        }
    }
    */
}