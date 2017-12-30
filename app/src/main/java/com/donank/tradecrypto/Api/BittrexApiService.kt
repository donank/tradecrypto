package com.donank.tradecrypto.Api

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by donank on 30/12/17.
 */
interface BittrexApiService {

    //api calls here

    companion object {

        fun create(moshi: Moshi, client: OkHttpClient): BittrexApiService {


            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create(moshi)
                            .asLenient())
                    .client(client)
                    .baseUrl("https://bittrex.com/api/v1.1/")
                    .build()

            return retrofit.create(BittrexApiService::class.java)
        }
    }

}