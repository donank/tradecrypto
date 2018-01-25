package com.donank.tradecrypto.Data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.migration.Migration
import com.donank.tradecrypto.Data.Dao.DashboardDao
import com.donank.tradecrypto.Data.Dao.TrackedCurrencyDao
import com.donank.tradecrypto.Data.Models.TrackedCurrency

@Database(entities = [DashboardDao::class, TrackedCurrency::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trackedCurrencyDao() : TrackedCurrencyDao
    abstract fun dashboardDao(): DashboardDao
}
