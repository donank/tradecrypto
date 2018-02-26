package com.donank.tradecrypto.Dagger

import android.app.Application
import android.arch.persistence.room.Room
import com.donank.tradecrypto.BaseApi.REST.CMCRESTInterface
import com.donank.tradecrypto.BaseData.AppDatabase
import com.squareup.moshi.*
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by donank on 30/12/17.
 */
@Module
class AppModule(private val app: Application) {
    @Provides
    @Singleton
    @ForApplication
    fun provideApplication() = app

    @Provides
    @Singleton
    fun providesAppDatabase(context: Application): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "my-trade-crypto-db")
                    .build()

    @Provides
    @Singleton
    fun providesTrackedCurrencyDao(database: AppDatabase) = database.trackedCurrencyDao()


    @Provides
    @Singleton
    fun provideJson(): Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


    @Provides
    @Singleton
    fun provideHttp(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideBittrexRESTInterface(moshi: Moshi, http: OkHttpClient) =
            RESTInterface.create(moshi, http)

    @Provides
    @Singleton
    fun provideCMCRESTInterfac(moshi: Moshi, http: OkHttpClient) =
            CMCRESTInterface.create(moshi, http)

    @Provides
    @Singleton
    fun providePoloniexRESTInterface(moshi: Moshi, http: OkHttpClient) =
            RESTInterface.create(moshi, http)
}

