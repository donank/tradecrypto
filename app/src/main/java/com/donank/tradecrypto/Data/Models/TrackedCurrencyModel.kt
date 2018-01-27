package com.donank.tradecrypto.Data.Models

import android.arch.persistence.room.*
import com.donank.tradecrypto.Data.Converter

class TrackedCurrencyModel{
    @Entity(tableName = "tracked_currency")
    data class TrackedCurrency (
            var ticker: String,
            var exchange: Exchanges,
            @ColumnInfo(name = "total_value")
            var totalValue: Double,
            @Relation(parentColumn = "id", entityColumn = "ticker_id")
            var trades : List<Trades>?,
            @PrimaryKey(autoGenerate = true)
            var id: Long
    )

    @Entity(tableName = "trades")
    data class Trades (
            @TypeConverters(Converter::class)
            var action: Action,
            var quantity : Double,
            var price : Double,
            @ColumnInfo(name = "total_value")
            var totalValue : Double,
            var date : Long,
            @ColumnInfo(name = "ticker_id")
            var tickerId : Long,
            @PrimaryKey(autoGenerate = true)
            var id: Long
    )
}