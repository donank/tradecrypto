package com.donank.tradecrypto.Services

import android.app.IntentService
import android.content.Intent


/**
 * Created by donank on 9/1/18.
 */
class TradeBotService : IntentService("TradeBotService"){


    override fun onHandleIntent(intent: Intent?) {
        val commandValue = intent!!.getIntExtra("command", 0)
        val exchange = intent.getStringExtra("exchange")
        val market = intent.getStringExtra("market")
        val useDefaultBotConf = intent.getBooleanExtra("useDefaultBotConf", false)
        val customConf = intent.getStringExtra("")
        val scriptUri = intent.getStringExtra("scriptUri")

        if(commandValue == 1){
            trade(scriptUri)
        }
        else stopTrade()
    }

    fun trade(scriptUri: String) {

    }

    fun stopTrade(){

    }
}