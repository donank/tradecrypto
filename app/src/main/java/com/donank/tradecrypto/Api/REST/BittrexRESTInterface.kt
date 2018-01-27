package com.donank.tradecrypto.Api.REST

import com.donank.tradecrypto.Data.Models.BittrexModel.*
import com.squareup.moshi.Moshi
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by donank on 30/12/17.
 */
interface BittrexRESTInterface {

    //api calls here
    @GET("public/getmarkets")
    fun getMarkets() : Observable<Market>

    @GET("public/getcurrencies")
    fun getCurrencies() : Observable<SupportedCurrencies>

    @GET("public/getticker")
    fun getTicker(@Query("market") market : String) : Observable<SpecificTickerValues>

    @GET("public/getmarketsummaries")
    fun getMarketSummary() : Observable<MarketSummary>

    @GET("public/getmarketsummary")
    fun getSpecificmarketSummary(@Query("market") market : String) : Observable<MarketSummary>

    @GET("public/getorderbook")
    fun getOrderBook(@Query("market") market : String,@Query("type") type : String) : Observable<OrderBook>

    @GET("public/getorderbook")
    fun getBothOrderBook(@Query("market") market : String,@Query("type") type : String = "both") : Observable<BothOrderBook>

    @GET("public/getmarkethistory")
    fun getMarketHistory(@Query("market") market : String) : Observable<SpecificMarketHistory>

    @GET("market/buylimit")
    fun buy(@Query("apikey") apikey: String, @Query("market") market : String, @Query("quantity") quantity : Double, @Query("rate") rate : Double) : Observable<BuySellLimit>

    @GET("market/selllimit")
    fun sell(@Query("apikey") apikey: String, @Query("market") market : String, @Query("quantity") quantity : Double, @Query("rate") rate : Double) : Observable<BuySellLimit>

    @GET("market/cancel")
    fun cancel(@Query("apikey") apikey: String, @Query("uuid") uuid : String) : Observable<CancelResult>

    @GET("market/getopenorders")
    fun getOpenOrders(@Query("apikey") apikey: String, @Query("market") market : String) : Observable<OpenOrders>

    @GET("account/getbalances")
    fun getBalances(@Query("apikey") apikey : String) : Observable<AccountBalance>

    @GET("account/getbalance")
    fun getSpecificBalance(@Query("apikey") apikey: String, @Query("currency") currency : String) : Observable<SpecificAccountBalance>

    @GET("account/getdepositaddress")
    fun getDepositAddress(@Query("apikey") apikey : String, @Query("currency") currency : String) : Observable<DepositAddress>

    @GET("account/withdraw")
    fun withdraw(@Query("currency") currency : String, @Query("quantity") quantity: Double, @Query("address") address : String, @Query("paymentid") paymentid : String) : Observable<Withdraw>

    @GET("account/getorder")
    fun getOrder(@Query("uuid") uuid : String) : Observable<SingleOrder>

    @GET("account/getorderhistory")
    fun getOrderHistory(@Query("market") market : String) : Observable<OrderHistory>

    @GET("account/getwithdrawalhistory")
    fun getWithdrawalHistory(@Query("currency") currency: String?) : Observable<TransferHistory>

    @GET("account/getdeposithistory")
    fun getDepositHistory(@Query("currency") currency: String?) : Observable<TransferHistory>

    companion object {

        fun create(moshi: Moshi, client: OkHttpClient): BittrexRESTInterface {


            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create(moshi)
                            .asLenient())
                    .client(client)
                    .baseUrl("https://bittrex.com/api/v1.1/")
                    .build()

            return retrofit.create(BittrexRESTInterface::class.java)
        }
    }

}