package com.donank.tradecrypto.Data.Dao

import android.arch.persistence.room.*
import com.donank.tradecrypto.Data.Models.DashboardModel
import io.reactivex.Flowable

/**
 * Created by donank on 26/1/18.
 */
@Dao interface DashboardDao {
    @Query("select * from dashboard_model")
    fun getAllCurrencies() : Flowable<List<DashboardModel>>

    @Query("select currency from dashboard_model")
    fun getAllTickers() : List<String>

    @Query("select * from dashboard_model where id = :id")
    fun CurrencyById(id : Long) : DashboardModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrency(currency: DashboardModel)

    @Delete
    fun deleteCurrency(currency: DashboardModel)
}