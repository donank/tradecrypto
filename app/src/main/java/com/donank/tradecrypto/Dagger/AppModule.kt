package com.donank.tradecrypto.Dagger

import android.app.Application
import com.squareup.moshi.*
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Named
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
    @Named("BittrexAPI")
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
}
