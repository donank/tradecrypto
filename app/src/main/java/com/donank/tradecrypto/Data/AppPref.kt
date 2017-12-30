package com.donank.tradecrypto.Data

import com.chibatching.kotpref.KotprefModel

/**
 * Created by donank on 30/12/17.
 */

object AppPref : KotprefModel() {
    var apikey by stringPref()
}