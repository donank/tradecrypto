package com.donank.tradecrypto.Data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.donank.tradecrypto.Data.Dao.TrackedCurrencyDao
import com.donank.tradecrypto.Data.Models.TrackedCurrency

@Database(entities = arrayOf(TrackedCurrency::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trackedCurrencyDao() : TrackedCurrencyDao
}