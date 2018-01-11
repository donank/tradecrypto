package com.donank.tradecrypto.Api

import com.donank.tradecrypto.Data.Exchanges.*
import javax.inject.Inject

class ApiHelper {

    @Inject lateinit var bitrexApiService : BittrexApiService

    fun getTickerPrice(market : String, exchange : String){
        when(exchange){
            BITTREX.toString() -> bitrexApiService.getTicker(market)
        }
    }
}