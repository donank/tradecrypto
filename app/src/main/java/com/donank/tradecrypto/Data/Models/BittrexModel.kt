package com.donank.tradecrypto.Data.Models

import java.util.*

/**
 * Created by donank on 28/12/17.
 */
class BittrexModel {

    //https://bittrex.com/api/v1.1/public/getmarkets
    data class Market(
            val success : Boolean = false,
            val message : String? = null,
            val result : List<MarketResult>? = null
    )

    data class MarketResult (
            val MarketCurrency: String? = null,
            val BaseCurrency: String? = null,
            val MarketCurrencyLong: String? = null,
            val BaseCurrencyLong: String? = null,
            val MinTradeSize: Double? = null,
            val MarketName: String? = null,
            val IsActive: Boolean? = null,
            val Created: Date? = null
    )

    //https://bittrex.com/api/v1.1/public/getcurrencies
    data class SupportedCurrencies (
            val success: Boolean = false,
            val message: String? = null,
            val result: List<SupportedCurrenciesResult>? = null
    )

    data class SupportedCurrenciesResult(
            val Currency: String? = null,
            val CurrencyLong: String? = null,
            val MinConfirmation: Int? = null,
            val TxFee: Double? = null,
            val IsActive: Boolean? = null,
            val CoinType: String? = null,
            val BaseAddress: Any? = null
    )

    //https://bittrex.com/api/v1.1/public/getticker
//param - "market" - required a string literal for the market (ex: BTC-LTC)
    data class SpecificTickerValues (
            val success: Boolean = false,
            val message: String? = null,
            val result: SpecificTickerValuesResult? = null
    )

    data class SpecificTickerValuesResult (
            val Bid: Double? = null,
            val Ask: Double? = null,
            val Last: Double? = null
    )

    //All Market Summary = https://bittrex.com/api/v1.1/public/getmarketsummaries
//Specific Market Summary = https://bittrex.com/api/v1.1/public/getmarketsummary?market=btc-ltc
//param(Specific Market Summary) - "market" - required a string literal for the market (ex: BTC-LTC)
    data class MarketSummary (
            val success: Boolean = false,
            val message: String? = null,
            val result: List<MarketSummaryResult>? = null
    )



    data class MarketSummaryResult (
            val MarketName : String? = null,
            val High : Double? = null,
            val Low : Double? = null,
            val Volume : Double? = null,
            val Last : Double? = null,
            val BaseVolume : Double? = null,
            val TimeStamp : Date? = null,
            val OpenBuyOrders : Int? = null,
            val OpenSellOrders : Int? = null,
            val PrevDay : Double? = null,
            val Created : Date? = null,
            val DisplayMarketName : String? = null
    )


    //https://bittrex.com/api/v1.1/public/getorderbook?market=BTC-LTC&type=both
//param - "market" - required a string literal for the market (ex: BTC-LTC)
//param - "type" required buy, sell or both to identify the type of orderbook to return.
    data class OrderBook (
            val success: Boolean = false,
            val message: String? = null,
            val result: List<Orders>
    )

    data class BothOrderBook (
            val success: Boolean = false,
            val message: String? = null,
            val result: List<BothOrderBookResult>? = null
    )

    data class BothOrderBookResult(
            val buy : List<Orders>? = null,
            val sell : List<Orders>? = null
    )

    data class Orders (
            val Quantity : Double? = null,
            val Rate : Double? = null
    )

    //https://bittrex.com/api/v1.1/public/getmarkethistory?market=BTC-DOGE
//param - "market" - required a string literal for the market (ex: BTC-LTC)
    data class SpecificMarketHistory (
            val success: Boolean = false,
            val message: String? = null,
            val result: List<SpecificMarketHistoryResult>? = null
    )

    data class SpecificMarketHistoryResult(
            val Id : Long? = null,
            val TimeStamp: Date? = null,
            val Quantity: Double? = null,
            val Price : Double? = null,
            val Total : Double? = null,
            val FillType :String? = null,
            val OrderType : String? = null
    )

    //Buy Limit url = https://bittrex.com/api/v1.1/market/buylimit?apikey=API_KEY&market=BTC-LTC&quantity=1.2&rate=1.3
//Sell Limit url = https://bittrex.com/api/v1.1/market/selllimit?apikey=API_KEY&market=BTC-LTC&quantity=1.2&rate=1.3
//param - "market" - required a string literal for the market (ex: BTC-LTC)
//param - "quantity" - required the amount to purchase
//param - "rate" - required the rate at which to place the order.
    data class BuySellLimit (
            val success: Boolean = false,
            val message: String? = null,
            val result: BuySellLimitResult? = null
    )

    data class BuySellLimitResult (
            val uuid : String? = null
    )

    //Cancel url = https://bittrex.com/api/v1.1/market/cancel?apikey=API_KEY&uuid=ORDER_UUID
//param - "uuid" required uuid of buy or sell order
    data class CancelResult (
            val success: Boolean = false,
            val message: String? = null,
            val result: Any? = null
    )

    //https://bittrex.com/api/v1.1/market/getopenorders?apikey=API_KEY&market=BTC-LTC
//param - "market" - required a string literal for the market (ex: BTC-LTC)
    data class OpenOrders (
            val success: Boolean = false,
            val message: String? = null,
            val result: List<OpenOrdersResult>? = null
    )

    data class OpenOrdersResult (
            val Uuid : String? = null,
            val OrderUuid : String? = null,
            val Exchange : String? = null,
            val OrderType : String? = null,
            val Quantity: Double? = null,
            val QuantityRemaining: Double? = null,
            val Limit : Double? = null,
            val CommisionPaid : Double? = null,
            val Price : Double? = null,
            val PricePerUnit : Double? = null,
            val Opened : Date? = null,
            val Closed : Date? = null,
            val CancelInitiated : Boolean? = null,
            val ImmediateOrCancel : Boolean? = null,
            val IsConditional : Boolean? = null,
            val Condition : Any? = null,
            val ConditionTarget : Any? = null
    )

    //All Balances = https://bittrex.com/api/v1.1/account/getbalances?apikey=API_KEY
//Specific balance = https://bittrex.com/api/v1.1/account/getbalance?apikey=API_KEY&currency=BTC
//param(Specific balance) - "currency" required a string literal for the currency (ex: LTC)
    data class AccountBalance (
            val success: Boolean = false,
            val message: String? = null,
            val result: List<AccountBalanceResult>? = null
    )

    data class SpecificAccountBalance (
            val success: Boolean = false,
            val message: String? = null,
            val result: AccountBalanceResult? = null
    )

    data class AccountBalanceResult (
            val Currency: String? = null,
            val Balance : Double? = null,
            val Available : Double? = null,
            val Pending : Double? = null,
            val CryptoAddress : String? = null,
            val Requested: Boolean? = null,
            val Uuid: String? = null
    )

    //https://bittrex.com/api/v1.1/account/getdepositaddress?apikey=API_KEY&currency=VTC
//param - "currency" required a string literal for the currency (ex: LTC)
    data class DepositAddress (
            val success: Boolean = false,
            val message: String? = null,
            val result: DepositAddressResult? = null
    )

    data class DepositAddressResult (
            val Currency :String? = null,
            val Address : String? = null
    )

    //https://bittrex.com/api/v1.1/account/withdraw?apikey=API_KEY&currency=EAC&quantity=20.40&address=EAC_ADDRESS
//param - "currency" - required a string literal for the currency (ie. BTC)
//param - "quantity" - required the quantity of coins to withdraw
//param - "address" - required he address where to send the funds.
//param - "paymentid" - optional used for CryptoNotes/BitShareX/Nxt optional field (memo/paymentid)
    data class Withdraw (
            val success: Boolean = false,
            val message: String? = null,
            val result: WithdrawResult? = null
    )

    data class WithdrawResult (
            val Uuid: String? = null
    )

    //https://bittrex.com/api/v1.1/account/getorder&uuid=0cb4c4e4-bdc7-4e13-8c13-430e587d2cc1
//param - "uuid" required uuid of buy or sell order
    data class SingleOrder (
            val success: Boolean = false,
            val message: String? = null,
            val result: SingleOrderResult? = null
    )

    data class SingleOrderResult (
            val Uuid : String? = null,
            val OrderUuid : String? = null,
            val Exchange : String? = null,
            val Type : String? = null,
            val Quantity: Double? = null,
            val QuantityRemaining: Double? = null,
            val Limit : Double? = null,
            val Reserved : Double? = null,
            val ReserveRemaining : Double? = null,
            val CommissionReserved : Double? = null,
            val CommissionReserveRemaining : Double? = null,
            val CommissionPaid: Double? = null,
            val Price : Double? = null,
            val PricePerUnit : Double? = null,
            val Opened : Date? = null,
            val Closed : Date? = null,
            val IsOpen : Boolean? = null,
            val Sentinel: String? = null,
            val CancelInitiated : Boolean? = null,
            val ImmediateOrCancel : Boolean? = null,
            val IsConditional : Boolean? = null,
            val Condition : Any? = null,
            val ConditionTarget : Any? = null
    )

    //https://bittrex.com/api/v1.1/account/getorderhistory
//param - "market" - required a string literal for the market (ex: BTC-LTC)
    data class OrderHistory (
            val success: Boolean = false,
            val message: String? = null,
            val result: List<OrderHistoryResult>? = null
    )

    data class OrderHistoryResult (
            val OrderUuid : String? = null,
            val Exchange : String? = null,
            val TimeStamp: Date? = null,
            val OrderType : String? = null,
            val Limit : Double? = null,
            val Quantity: Double? = null,
            val QuantityRemaining: Double? = null,
            val Commision : Double? = null,
            val Price : Double? = null,
            val PricePerUnit : Double? = null,
            val IsConditional : Boolean? = null,
            val Condition : Any? = null,
            val ConditionTarget : Any? = null,
            val ImmediateOrCancel : Boolean? = null
    )

    //Withdrawal = https://bittrex.com/api/v1.1/account/getwithdrawalhistory?currency=BTC
//Deposit = https://bittrex.com/api/v1.1/account/getdeposithistory?currency=BTC
//param - "currency" - required a string literal for the currency (ie. BTC)
    data class TransferHistory (
            val success: Boolean = false,
            val message: String? = null,
            val result: List<TransferHistoryResult>? = null
    )

    data class TransferHistoryResult (
            val PaymentUuid : String? = null,
            val Currency: String? = null,
            val Amount : Double? = null,
            val Address : String? = null,
            val Opened: Date? = null,
            val Authoried: Boolean? = null,
            val PendingPayment: Boolean? = null,
            val TxCost: Double? = null,
            val TxId: String? = null,
            val Canceled: Boolean? = null,
            val InvalidAddress : Boolean? = null
    )
}