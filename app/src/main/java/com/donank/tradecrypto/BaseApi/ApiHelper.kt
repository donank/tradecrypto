package com.donank.tradecrypto.BaseApi

import javax.inject.Inject

class ApiHelper {

    @Inject lateinit var bittrexRESTInterface: RESTInterface
    @Inject lateinit var poloniexRESTInterface: com.donank.tradecrypto.Exchanges.Poloniex.Api.RESTInterface
/*
    suspend fun getTickerPrice(market: String?, exchange: String?): DashboardModel {
        val dashModel = DashboardModel()
        when (exchange) {
            "BITTREX" -> {
                     bittrexRESTInterface.getTicker(market!!)
                             .subscribeOn(Schedulers.newThread())
                             .subscribe {
                                 if (it.success) {
                                     dashModel.price = it.result!!.Last
                                     dashModel.currency = market
                                     dashModel.exchange = BITTREX
                                 } else Log.d("$exchange: getTicker($market) failed", "${it.message}")
                             }
                 }
            }
            "POLONIEX" -> {
                poloniexRESTInterface.getTicker()
                        .subscribeOn(Schedulers.newThread())
                        .subscribe {
                            if (!it.isEmpty()) {
                                it.forEach {
                                    if (it.key == market) {
                                        dashModel.price = it.value.last.toDouble()
                                        dashModel.currency = market
                                        dashModel.exchange = POLONIEX
                                        dashModel.percentChange = it.value.percentChange.toFloat()
                                    }
                                }
                            }
                        }

    }

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