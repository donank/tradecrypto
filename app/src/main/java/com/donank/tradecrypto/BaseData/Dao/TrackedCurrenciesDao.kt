package com.donank.tradecrypto.BaseData.Dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.donank.tradecrypto.BaseData.Models.TrackedCurrency
import io.reactivex.Flowable

@Dao interface TrackedCurrencyDao {

    @Query("select * from tracked_currency")
    fun getAllCurrencies() : Flowable<List<TrackedCurrency>>

    @Query("select ticker from tracked_currency")
    fun getAllTickers() : Flowable<List<String>>

    @Query("select * from tracked_currency where id = :id")
    fun TrackedCurrencyById(id : Long) : TrackedCurrency

    @Insert(onConflict = REPLACE)
    fun insertCurrency(trCurrency: TrackedCurrency)

    @Delete
    fun deleteCurrency(trCurrency: TrackedCurrency)
}