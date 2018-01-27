package com.donank.tradecrypto.Data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.donank.tradecrypto.Data.Dao.TrackedCurrencyDao
import com.donank.tradecrypto.Data.Models.TrackedCurrencyModel.*

@Database(entities = [TrackedCurrency::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trackedCurrencyDao() : TrackedCurrencyDao
}
