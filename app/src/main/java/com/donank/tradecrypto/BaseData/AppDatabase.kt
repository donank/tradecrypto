package com.donank.tradecrypto.BaseData

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.donank.tradecrypto.BaseData.Dao.TrackedCurrencyDao
import com.donank.tradecrypto.BaseData.Models.TrackedCurrency

@Database(entities = arrayOf(TrackedCurrency::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trackedCurrencyDao() : TrackedCurrencyDao
}