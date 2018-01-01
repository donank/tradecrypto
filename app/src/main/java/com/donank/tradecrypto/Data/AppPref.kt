package com.donank.tradecrypto.Data

import android.content.SharedPreferences
import com.chibatching.kotpref.KotprefModel

/**
 * Created by donank on 30/12/17.
 */


object AppPref : KotprefModel() {
    var bittrexApiKey by stringPref()
    var bittrexSecretKey by stringPref()
    var poloniexApiKey by stringPref()
    var poloniexSecretKey by stringPref()
}
