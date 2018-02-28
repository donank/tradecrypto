package com.donank.tradecrypto.BaseApi

import com.donank.tradecrypto.BaseData.Models.Exchanges
import com.donank.tradecrypto.BaseData.Models.Exchanges.*
import com.donank.tradecrypto.BaseData.Models.TrackedCurrency
import com.donank.tradecrypto.Exchanges.Bittrex.BittrexRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

//Aggregate data from api, save to db and return the same data
class BaseRepository {

    @Inject lateinit var bittrexRepository: BittrexRepository
    fun getMarkets(exchange : Exchanges): Observable<List<TrackedCurrency>> {
       return when(exchange){

            BITTREX -> {
                val trCurrList = listOf<TrackedCurrency>()
                bittrexRepository.getMarkets().subscribeOn(Schedulers.newThread())
                        .map {
                            it.forEach {
                                trCurrList.plus(TrackedCurrency(
                                        ticker = it.BaseCurrency,
                                        exchange = BITTREX

                                ))
                            }
                            trCurrList
                        }
            }
            POLONIEX -> TODO()
            BINANCE -> TODO()
            RADAR -> TODO()
            NOEXCHANGE -> TODO()
       }
    }

}