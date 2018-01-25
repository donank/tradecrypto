package com.donank.tradecrypto.Dagger

import android.app.Application
import android.arch.persistence.room.Room
import com.donank.tradecrypto.Api.ApiHelper
import com.donank.tradecrypto.Api.REST.BittrexRESTInterface
import com.donank.tradecrypto.Api.REST.CMCRESTInterface
import com.donank.tradecrypto.Api.REST.PoloniexRESTInterface
import com.donank.tradecrypto.Data.AppDatabase
import com.donank.tradecrypto.Data.MIgrations.Migrate_1_2
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
                    .addMigrations(Migrate_1_2())
                    .build()

    @Provides
    @Singleton
    fun providesTrackedCurrencyDao(database: AppDatabase) = database.trackedCurrencyDao()

    @Provides
    @Singleton
    fun providesDashboardDao(database: AppDatabase) = database.dashboardDao()


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
            BittrexRESTInterface.create(moshi, http)

    @Provides
    @Singleton
    fun provideCMCRESTInterfac(moshi: Moshi, http: OkHttpClient) =
            CMCRESTInterface.create(moshi, http)

    @Provides
    @Singleton
    fun providePoloniexRESTInterface(moshi: Moshi, http: OkHttpClient) =
            PoloniexRESTInterface.create(moshi, http)

    @Provides
    @Singleton
    internal fun provideApiHelper(bittrexRESTInterface: BittrexRESTInterface, poloniexRESTInterface: PoloniexRESTInterface): ApiHelper {
        return ApiHelper(bittrexRESTInterface, poloniexRESTInterface)
    }

}

