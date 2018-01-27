package com.donank.tradecrypto.Data.Models

import java.util.*

/**
 * Created by donank on 28/12/17.
 */
class BittrexModel {

    //https://bittrex.com/api/v1.1/public/getmarkets
    data class Market(
            val success : Boolean = false,
            val message : String,
            val result : List<MarketResult>
    )

    data class MarketResult (
            val MarketCurrency: String,
            val BaseCurrency: String,
            val MarketCurrencyLong: String,
            val BaseCurrencyLong: String,
            val MinTradeSize: Double,
            val MarketName: String,
            val IsActive: Boolean,
            val Created: Date
    )

    //https://bittrex.com/api/v1.1/public/getcurrencies
    data class SupportedCurrencies (
            val success: Boolean = false,
            val message: String,
            val result: List<SupportedCurrenciesResult>
    )

    data class SupportedCurrenciesResult(
            val Currency: String,
            val CurrencyLong: String,
            val MinConfirmation: Int,
            val TxFee: Double,
            val IsActive: Boolean,
            val CoinType: String,
            val BaseAddress: Any
    )

    //https://bittrex.com/api/v1.1/public/getticker
//param - "market" - required a string literal for the market (ex: BTC-LTC)
    data class SpecificTickerValues (
            val success: Boolean = false,
            val message: String,
            val result: SpecificTickerValuesResult
    )

    data class SpecificTickerValuesResult (
            val Bid: Double,
            val Ask: Double,
            val Last: Double
    )

    //All Market Summary = https://bittrex.com/api/v1.1/public/getmarketsummaries
//Specific Market Summary = https://bittrex.com/api/v1.1/public/getmarketsummary?market=btc-ltc
//param(Specific Market Summary) - "market" - required a string literal for the market (ex: BTC-LTC)
    data class MarketSummary (
            val success: Boolean = false,
            val message: String,
            val result: List<MarketSummaryResult>
    )



    data class MarketSummaryResult (
            val MarketName : String,
            val High : Double,
            val Low : Double,
            val Volume : Double,
            val Last : Double,
            val BaseVolume : Double,
            val TimeStamp : Date,
            val OpenBuyOrders : Int,
            val OpenSellOrders : Int,
            val PrevDay : Double,
            val Created : Date,
            val DisplayMarketName : String
    )


    //https://bittrex.com/api/v1.1/public/getorderbook?market=BTC-LTC&type=both
//param - "market" - required a string literal for the market (ex: BTC-LTC)
//param - "type" required buy, sell or both to identify the type of orderbook to return.
    data class OrderBook (
            val success: Boolean = false,
            val message: String,
            val result: List<Orders>
    )

    data class BothOrderBook (
            val success: Boolean = false,
            val message: String,
            val result: List<BothOrderBookResult>
    )

    data class BothOrderBookResult(
            val buy : List<Orders>,
            val sell : List<Orders>
    )

    data class Orders (
            val Quantity : Double,
            val Rate : Double
    )

    //https://bittrex.com/api/v1.1/public/getmarkethistory?market=BTC-DOGE
//param - "market" - required a string literal for the market (ex: BTC-LTC)
    data class SpecificMarketHistory (
            val success: Boolean = false,
            val message: String,
            val result: List<SpecificMarketHistoryResult>
    )

    data class SpecificMarketHistoryResult(
            val Id : Long,
            val TimeStamp: Date,
            val Quantity: Double,
            val Price : Double,
            val Total : Double,
            val FillType :String,
            val OrderType : String
    )

    //Buy Limit url = https://bittrex.com/api/v1.1/market/buylimit?apikey=API_KEY&market=BTC-LTC&quantity=1.2&rate=1.3
//Sell Limit url = https://bittrex.com/api/v1.1/market/selllimit?apikey=API_KEY&market=BTC-LTC&quantity=1.2&rate=1.3
//param - "market" - required a string literal for the market (ex: BTC-LTC)
//param - "quantity" - required the amount to purchase
//param - "rate" - required the rate at which to place the order.
    data class BuySellLimit (
            val success: Boolean = false,
            val message: String,
            val result: BuySellLimitResult
    )

    data class BuySellLimitResult (
            val uuid : String
    )

    //Cancel url = https://bittrex.com/api/v1.1/market/cancel?apikey=API_KEY&uuid=ORDER_UUID
//param - "uuid" required uuid of buy or sell order
    data class CancelResult (
            val success: Boolean = false,
            val message: String,
            val result: Any
    )

    //https://bittrex.com/api/v1.1/market/getopenorders?apikey=API_KEY&market=BTC-LTC
//param - "market" - required a string literal for the market (ex: BTC-LTC)
    data class OpenOrders (
            val success: Boolean = false,
            val message: String,
            val result: List<OpenOrdersResult>
    )

    data class OpenOrdersResult (
            val Uuid : String,
            val OrderUuid : String,
            val Exchange : String,
            val OrderType : String,
            val Quantity: Double,
            val QuantityRemaining: Double,
            val Limit : Double,
            val CommisionPaid : Double,
            val Price : Double,
            val PricePerUnit : Double,
            val Opened : Date,
            val Closed : Date,
            val CancelInitiated : Boolean,
            val ImmediateOrCancel : Boolean,
            val IsConditional : Boolean,
            val Condition : Any,
            val ConditionTarget : Any
    )

    //All Balances = https://bittrex.com/api/v1.1/account/getbalances?apikey=API_KEY
//Specific balance = https://bittrex.com/api/v1.1/account/getbalance?apikey=API_KEY&currency=BTC
//param(Specific balance) - "currency" required a string literal for the currency (ex: LTC)
    data class AccountBalance (
            val success: Boolean = false,
            val message: String,
            val result: List<AccountBalanceResult>
    )

    data class SpecificAccountBalance (
            val success: Boolean = false,
            val message: String,
            val result: AccountBalanceResult
    )

    data class AccountBalanceResult (
            val Currency: String,
            val Balance : Double,
            val Available : Double,
            val Pending : Double,
            val CryptoAddress : String,
            val Requested: Boolean,
            val Uuid: String
    )

    //https://bittrex.com/api/v1.1/account/getdepositaddress?apikey=API_KEY&currency=VTC
//param - "currency" required a string literal for the currency (ex: LTC)
    data class DepositAddress (
            val success: Boolean = false,
            val message: String,
            val result: DepositAddressResult
    )

    data class DepositAddressResult (
            val Currency :String,
            val Address : String
    )

    //https://bittrex.com/api/v1.1/account/withdraw?apikey=API_KEY&currency=EAC&quantity=20.40&address=EAC_ADDRESS
//param - "currency" - required a string literal for the currency (ie. BTC)
//param - "quantity" - required the quantity of coins to withdraw
//param - "address" - required he address where to send the funds.
//param - "paymentid" - optional used for CryptoNotes/BitShareX/Nxt optional field (memo/paymentid)
    data class Withdraw (
            val success: Boolean = false,
            val message: String,
            val result: WithdrawResult
    )

    data class WithdrawResult (
            val Uuid: String
    )

    //https://bittrex.com/api/v1.1/account/getorder&uuid=0cb4c4e4-bdc7-4e13-8c13-430e587d2cc1
//param - "uuid" required uuid of buy or sell order
    data class SingleOrder (
            val success: Boolean = false,
            val message: String,
            val result: SingleOrderResult
    )

    data class SingleOrderResult (
            val Uuid : String,
            val OrderUuid : String,
            val Exchange : String,
            val Type : String,
            val Quantity: Double,
            val QuantityRemaining: Double,
            val Limit : Double,
            val Reserved : Double,
            val ReserveRemaining : Double,
            val CommissionReserved : Double,
            val CommissionReserveRemaining : Double,
            val CommissionPaid: Double,
            val Price : Double,
            val PricePerUnit : Double,
            val Opened : Date,
            val Closed : Date,
            val IsOpen : Boolean,
            val Sentinel: String,
            val CancelInitiated : Boolean,
            val ImmediateOrCancel : Boolean,
            val IsConditional : Boolean,
            val Condition : Any,
            val ConditionTarget : Any
    )

    //https://bittrex.com/api/v1.1/account/getorderhistory
//param - "market" - required a string literal for the market (ex: BTC-LTC)
    data class OrderHistory (
            val success: Boolean = false,
            val message: String,
            val result: List<OrderHistoryResult>
    )

    data class OrderHistoryResult (
            val OrderUuid : String,
            val Exchange : String,
            val TimeStamp: Date,
            val OrderType : String,
            val Limit : Double,
            val Quantity: Double,
            val QuantityRemaining: Double,
            val Commision : Double,
            val Price : Double,
            val PricePerUnit : Double,
            val IsConditional : Boolean,
            val Condition : Any,
            val ConditionTarget : Any,
            val ImmediateOrCancel : Boolean
    )

    //Withdrawal = https://bittrex.com/api/v1.1/account/getwithdrawalhistory?currency=BTC
//Deposit = https://bittrex.com/api/v1.1/account/getdeposithistory?currency=BTC
//param - "currency" - required a string literal for the currency (ie. BTC)
    data class TransferHistory (
            val success: Boolean = false,
            val message: String,
            val result: List<TransferHistoryResult>
    )

    data class TransferHistoryResult (
            val PaymentUuid : String,
            val Currency: String,
            val Amount : Double,
            val Address : String,
            val Opened: Date,
            val Authoried: Boolean,
            val PendingPayment: Boolean,
            val TxCost: Double,
            val TxId: String,
            val Canceled: Boolean,
            val InvalidAddress : Boolean
    )
}