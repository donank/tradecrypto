package com.donank.tradecrypto.Exchanges.Bittrex

import android.annotation.SuppressLint
import com.donank.tradecrypto.BaseData.Models.DashboardModel
import com.donank.tradecrypto.Exchanges.Bittrex.Api.BittrexRESTInterface
import com.donank.tradecrypto.Exchanges.Bittrex.Data.Model
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@SuppressLint("CheckResult")
class BittrexRepository {

    @Inject lateinit var apiInterface : BittrexRESTInterface

    fun getMarkets() : Observable<List<Model.MarketResult>>{

        return apiInterface.getMarkets()
                .subscribeOn(Schedulers.newThread())
                .map {
                    if (it.success) {
                        it.result!!
                    } else {
                        listOf()
                    }
                }
    }
}