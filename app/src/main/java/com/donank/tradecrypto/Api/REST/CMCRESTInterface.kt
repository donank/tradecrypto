package com.donank.tradecrypto.Api.REST

import com.donank.tradecrypto.Data.CMCModel
import com.squareup.moshi.Moshi
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface CMCRESTInterface {


    @GET("")
    fun getTickerValue (id : String) : Observable<CMCModel>

    companion object {

        fun create(moshi: Moshi, client: OkHttpClient): CMCRESTInterface {


            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create(moshi)
                            .asLenient())
                    .client(client)
                    .baseUrl(" https://api.coinmarketcap.com/v1/ticker/")
                    .build()

            return retrofit.create(CMCRESTInterface::class.java)
        }
    }
}