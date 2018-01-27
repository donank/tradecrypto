package com.donank.tradecrypto.Api

import android.util.Log
import com.donank.tradecrypto.Api.REST.BittrexRESTInterface
import com.donank.tradecrypto.Api.REST.PoloniexRESTInterface
import io.reactivex.schedulers.Schedulers
class ApiHelper{

    fun getTickerPrice(market: String, exchange: String) {
        lateinit var bittrexRESTInterface: BittrexRESTInterface
        lateinit var poloniexRESTInterface : PoloniexRESTInterface
        Log.d("getTickerPrice", "$market | $exchange")
        when (exchange) {
            "BITTREX" -> {
                Log.d("Inside ", "BITTREX")
                    bittrexRESTInterface.getTicker(market)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(Schedulers.newThread())
                            .subscribe ({
                                if (it.success) {
                                    Log.d("Request Success", "$exchange- $market : ${it.result.Last}")
                                } else Log.d("$exchange: getTicker($market) failed", "${it.message}")
                            },{
                                Log.d("Error on Bitt Request","${it.message}")
                            },{
                                Log.d("Request success","Do something")
                            })

            }
            "POLONIEX" ->  {
                Log.d("Inside ", "POLONIEX")
                    poloniexRESTInterface.getTicker()
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(Schedulers.newThread())
                            .subscribe ({
                                if (!it.isEmpty()) {
                                    Log.d("Request Success","${it.size}")
                                    it.forEach {
                                        if (it.key == market) {
                                            Log.d("Market found", "$exchange- $market : ${it.key} | ${it.value}")
                                        }
                                    }
                                } else Log.d("POLONIEX ", "Request Failed")
                            }, {
                                Log.d("Error on Polo Request","${it.message}")
                            },{
                                Log.d("Request success","Do something")
                            })

            }
        }
    }
/*

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