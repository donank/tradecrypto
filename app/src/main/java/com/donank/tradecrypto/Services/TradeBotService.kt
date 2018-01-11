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
        val totalAmount = intent.getDoubleExtra("totalAmount", 0.0)
        val useDefaultBotConf = intent.getBooleanExtra("useDefaultBotConf", false)
        val customConf = intent.getStringExtra("")
        val stopLimit = intent.getDoubleExtra("stopLimit", 0.0)
        val stopTime = intent.getLongExtra("stopTime", 0)

        if(commandValue == 1){
            trade(exchange,market, totalAmount, stopLimit, stopTime)
        }
        else stopTrade()
    }

    fun trade(exchange: String, market: String, totalAmount: Double, stopLimit: Double, stopTime: Long) {

    }

    fun stopTrade(){

    }
}