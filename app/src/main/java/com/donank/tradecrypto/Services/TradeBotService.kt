package com.donank.tradecrypto.Services

import android.app.IntentService
import android.app.Notification
import android.content.Intent
import android.os.IBinder
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.donank.tradecrypto.R


/**
 * Created by donank on 9/1/18.
 */
class TradeBotService : IntentService("TradeBotService") {

    override fun onCreate() {
        super.onCreate()
        raiseNotification()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        closeOpenSockets()

    }


    override fun onDestroy() {
        super.onDestroy()
        closeOpenSockets()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }


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

    fun raiseNotification(){
        val b = NotificationCompat.Builder(this, "bot")
        b.setAutoCancel(true).setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setOngoing(true)

        try {
            b.setContentTitle(getString(R.string.service_name))
                    .setContentText(getString(R.string.tradebot_service_context))
        }catch (e : Exception)
        {
            Log.d("raiseNotification", "$e")
        }
    }

    fun closeOpenSockets(){

    }



}