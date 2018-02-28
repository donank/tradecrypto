package com.donank.tradecrypto.BaseData

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.donank.tradecrypto.BaseData.Dao.TrackedCurrencyDao
import com.donank.tradecrypto.BaseData.Models.TrackedCurrency

@Database(entities = [(TrackedCurrency::class)], version = 1, exportSchema = false)
@TypeConverters(BaseConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trackedCurrencyDao() : TrackedCurrencyDao
}