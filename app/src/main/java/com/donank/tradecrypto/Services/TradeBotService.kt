package com.donank.tradecrypto.Services

import android.app.IntentService
import android.content.Intent


/**
 * Created by donank on 9/1/18.
 */
class TradeBotService : IntentService("TradeBotService"){
    override fun onHandleIntent(intent: Intent?) {
        val commandValue = intent!!.getIntExtra("command", 0)
        val market = intent.getStringExtra("market")
        val totalAmount = intent.getDoubleExtra("totalAmount", 0.0)
        val useDefaultBotConf = intent.getBooleanExtra("useDefaultBotConf", false)
        val customConf = intent.getStringExtra("")

        if(commandValue == 1){
            trade()
        }
        else stopTrade()
    }

    fun trade(){

    }

    fun stopTrade(){

    }
}