package com.donank.tradecrypto.Exchanges.Poloniex.Data

import java.util.*

/**
 * Created by donank on 30/12/17.
 */
class Model {

    data class Ticker(
            val last : String,
            val lowestAsk : String,
            val highestBid : String,
            val percentChange : String,
            val baseVolume : String,
            val quoteVolume : String
    )

    data class Volume (
            val volume : Map<String, String>
    )

    data class OrderBook(
            val asks : List<Pair<Int, Int>>,
            val bids : List<Pair<Int, Int>>,
            val isFrozen : Int,
            val seq : Long
    )

    data class TradeHistory (
            val date : Date,
            val type : String,
            val rate : String,
            val amount : String,
            val total : String
    )

    data class ChartData(
            val date : Long,
            val high : Double,
            val low : Double,
            val open : Double,
            val close : Double,
            val volume : Double,
            val quoteVolume : Double,
            val weightedAverage : Double
    )

    data class CurrencyData (
            val maxDailyWithdrawal : Long,
            val txFee : Float,
            val minConf : Int,
            val disabled : Int
    )

    data class PoloBalance (
            val currency : String,
            val balance : String
    )

    data class DepositAddress (
            val currency: String,
            val address : String
    )

    data class NewAddress (
            val success : Int,
            val response : String
    )

    data class TransferHistory (
            val deposits : List<Deposit>,
            val withdrawals: List<Withdrawal>
    )

    data class Deposit (
            val currency: String,
            val address: String,
            val amount : String,
            val confirmations : Int,
            val txid : String,
            val timestamp : Long,
            val status : String
    )

    data class Withdrawal (
            val withdrawalNumber : Long,
            val currency: String,
            val address: String,
            val amount : String,
            val timestamp : Long,
            val status : String,
            val ipAddress : String
    )

    data class SingleMarketOpenOrder (
            val orderNumber : String,
            val type : String,
            val rate : String,
            val amount : String,
            val total : String
    )

    //todo "BTC_XCP" : [], "BTC_ETH" : [], ....
    data class AllMarketOpenOrders (
            val currencyPair : List<SingleMarketOpenOrder>
    )

    data class SingleMarketTradeHistory (
            val globalTradeID : Long,
            val tradeID : String,
            val date : Date,
            val rate : String,
            val amount : String,
            val total : String,
            val fee : String,
            val orderNumber: String,
            val type : String,
            val category : String
    )

    data class AllMarketTradeHistory (
            val currencyPair : List<SingleMarketOpenOrder>
    )

    data class Trade (
            val orderNumber: Long,
            val resultingTrades : List<TradeResult>
    )

    data class TradeResult (
            val amount : String,
            val date : Date,
            val rate : String,
            val total : String,
            val tradeID : String,
            val type : String
    )

    data class Cancel (
            val success : Int
    )

    data class MoveOrderResult (
            val success: Int,
            val orderNumber: String,
            val resultingTrades: MoveOrderResultingTrade
    )

    data class MoveOrderResultingTrade (
            val currencyPair: List<TradeResult>
    )

    data class Withdraw (
            val response : String
    )

    data class Fee (
            val makerFee : String,
            val takerFee : String,
            val thirtyDayVolume : String
    )
}


