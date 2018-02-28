package com.donank.tradecrypto.BaseData

import android.arch.persistence.room.TypeConverter
import com.donank.tradecrypto.BaseData.Models.Action
import com.donank.tradecrypto.BaseData.Models.Exchanges
import com.donank.tradecrypto.BaseData.Models.Exchanges.*

class BaseConverter {

    @TypeConverter
    fun exchangeToString(exchanges: Exchanges): String{
        return exchanges.name
    }

    @TypeConverter
    fun stringToexchange(string: String): Exchanges{
        return valueOf(string)
    }

    @TypeConverter
    fun actionToString(action: Action): String{
        return action.name
    }

    @TypeConverter
    fun stringToAction(string: String): Action{
        return Action.valueOf(string)
    }
}