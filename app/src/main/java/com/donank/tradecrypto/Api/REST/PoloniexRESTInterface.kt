package com.donank.tradecrypto.Api.REST

import com.donank.tradecrypto.Data.Models.PoloniexModel.*
import com.squareup.moshi.Moshi
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PoloniexRESTInterface {

    @GET("")
    suspend fun getTicker(
            @Query("command") command: String = "returnTicker"): Observable<Map<String, Ticker>>

    @GET("")
    fun get24Volume(@Query("command") command: String = "return24Volume"): Observable<Map<String, Volume>>

    @GET("")
    fun getOrderBook(@Query("command") command: String = "returnOrderBook"): Observable<OrderBook>

    @GET("")
    fun getOrderBook(@Query("command") command: String = "returnOrderBook",
                     @Query("currencyPair") currencyPair : String,
                     @Query("depth")depth : Int?
    ): Observable<Map<String, OrderBook>>

    @GET("")
    fun getTradeHistory(
            @Query("command") command: String = "returnTradeHistory",
            @Query("currencyPair") currencyPair : String,
            @Query("start") start: Long,
            @Query("end") end : Long
    ) : Observable<List<TradeHistory>>

    @GET("")
    fun getChartData(
            @Query("command") command: String = "returnChartData",
            @Query("currencyPair") currencyPair : String,
            @Query("start") start: Long,
            @Query("end") end : Long,
            @Query("period") period : Long
    ) : Observable<List<ChartData>>

    @GET("")
    fun getCurrencyData(@Query("command") command : String = "returnCurrencies") : Observable<Map<String, CurrencyData>>


    companion object {

        fun create(moshi: Moshi, client: OkHttpClient): PoloniexRESTInterface {


            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create(moshi)
                            .asLenient())
                    .client(client)
                    .baseUrl(" https://poloniex.com/public")
                    .build()

            return retrofit.create(PoloniexRESTInterface::class.java)
        }
    }
}