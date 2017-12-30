package com.donank.tradecrypto.Dagger


import android.app.Application
import com.donank.tradecrypto.Activity.MainActivity
import com.donank.tradecrypto.Fragments.Bittrex
import com.donank.tradecrypto.Fragments.Dashboard
import com.donank.tradecrypto.Fragments.Poloniex
import com.donank.tradecrypto.Fragments.Settings
import dagger.Component
import javax.inject.Singleton

/**
 * Created by donank on 30/12/17.
 */

@Singleton
@Component(modules = [(AppModule::class)])

interface AppComponent {
    fun inject(app: Application)
    fun inject(mainActivity: MainActivity)
    fun inject(bittrex: Bittrex)
    fun inject(poloniex: Poloniex)
    fun inject(settings: Settings)
    fun inject(dashboard: Dashboard)
}