package com.donank.tradecrypto.Dagger


import android.app.Application
import com.donank.tradecrypto.BaseActivity.MainActivity
import com.donank.tradecrypto.Fragments.*
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
    fun inject(exchangeDashboard: ExchangeDashboard)
    fun inject(settings: Settings)
    fun inject(dashboard: Dashboard)
    fun inject(trade: Trade)
    fun inject(tradeBotDashboard: TradeBotDashboard)
}