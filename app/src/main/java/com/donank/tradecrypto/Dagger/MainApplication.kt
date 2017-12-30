package com.donank.tradecrypto.Dagger

import android.app.Application

/**
 * Created by donank on 30/12/17.
 */
class MainApplication : Application() {
    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
        instance = this
    }

    companion object {
        lateinit var instance: MainApplication
    }
}