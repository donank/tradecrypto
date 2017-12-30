package com.donank.tradecrypto.Data

import java.util.*

/**
 * Created by donank on 28/12/17.
 */

//https://bittrex.com/api/v1.1/public/getmarkets
data class Market(
        val success : Boolean? = null,
        val message : String? = null,
        val result : List<MarketResult>? = null
)

data class MarketResult (
    var MarketCurrency: String? = null,
    var BaseCurrency: String? = null,
    var MarketCurrencyLong: String? = null,
    var BaseCurrencyLong: String? = null,
    var MinTradeSize: Double? = null,
    var MarketName: String? = null,
    var IsActive: Boolean? = null,
    var Created: Date? = null
)

//https://bittrex.com/api/v1.1/public/getcurrencies
data class SupportedCurrencies (
    var success: Boolean? = null,
    var message: String? = null,
    var result: List<SupportedCurrenciesResult>? = null
)

data class SupportedCurrenciesResult(
        var Currency: String? = null,
        var CurrencyLong: String? = null,
        var MinConfirmation: Int? = null,
        var TxFee: Double? = null,
        var IsActive: Boolean? = null,
        var CoinType: String? = null,
        var BaseAddress: Any? = null
)

//https://bittrex.com/api/v1.1/public/getticker
//param - "market" - required a string literal for the market (ex: BTC-LTC)
data class SpecificTickerValues (
        var success: Boolean? = null,
        var message: String? = null,
        var result: SpecificTickerValuesResult? = null
)

data class SpecificTickerValuesResult (
        var Bid: Double? = null,
        var Ask: Double? = null,
        var Last: Double? = null
)

//All Market Summary = https://bittrex.com/api/v1.1/public/getmarketsummaries
//Specific Market Summary = https://bittrex.com/api/v1.1/public/getmarketsummary?market=btc-ltc
//param(Specific Market Summary) - "market" - required a string literal for the market (ex: BTC-LTC)
data class MarketSummary (
        var success: Boolean? = null,
        var message: String? = null,
        var result: List<MarketSummaryResult>? = null
)



data class MarketSummaryResult (
        var MarketName : String? = null,
        var High : Double? = null,
        var Low : Double? = null,
        var Volume : Double? = null,
        var Last : Double? = null,
        var BaseVolume : Double? = null,
        var TimeStamp : Date? = null,
        var OpenBuyOrders : Int? = null,
        var OpenSellOrders : Int? = null,
        var PrevDay : Double? = null,
        var Created : Date? = null,
        var DisplayMarketName : String? = null
)


//https://bittrex.com/api/v1.1/public/getorderbook?market=BTC-LTC&type=both
//param - "market" - required a string literal for the market (ex: BTC-LTC)
//param - "type" required buy, sell or both to identify the type of orderbook to return.
data class OrderBook (
        var success: Boolean? = null,
        var message: String? = null,
        var result: List<OrderBookResult>? = null
)

data class OrderBookResult(
        var buy : List<Orders>? = null,
        var sell : List<Orders>? = null
)

data class Orders (
        var Quantity : Double? = null,
        var Rate : Double? = null
)

//https://bittrex.com/api/v1.1/public/getmarkethistory?market=BTC-DOGE
//param - "market" - required a string literal for the market (ex: BTC-LTC)
data class SpecificMarketHistory (
        var success: Boolean? = null,
        var message: String? = null,
        var result: List<SpecificMarketHistoryResult>? = null
)

data class SpecificMarketHistoryResult(
        var Id : Long? = null,
        var TimeStamp: Date? = null,
        var Quantity: Double? = null,
        var Price : Double? = null,
        var Total : Double? = null,
        var FillType :String? = null,
        var OrderType : String? = null
)

//Buy Limit url = https://bittrex.com/api/v1.1/market/buylimit?apikey=API_KEY&market=BTC-LTC&quantity=1.2&rate=1.3
//Sell Limit url = https://bittrex.com/api/v1.1/market/selllimit?apikey=API_KEY&market=BTC-LTC&quantity=1.2&rate=1.3
//param - "market" - required a string literal for the market (ex: BTC-LTC)
//param - "quantity" - required the amount to purchase
//param - "rate" - required the rate at which to place the order.
data class BuySellLimit (
        var success: Boolean? = null,
        var message: String? = null,
        var result: BuySellLimitResult? = null
)

data class BuySellLimitResult (
        var uuid : String? = null
)

//Cancel url = https://bittrex.com/api/v1.1/market/cancel?apikey=API_KEY&uuid=ORDER_UUID
//param - "uuid" required uuid of buy or sell order
data class CancelResult (
        var success: Boolean? = null,
        var message: String? = null,
        var result: Any? = null
)

//https://bittrex.com/api/v1.1/market/getopenorders?apikey=API_KEY&market=BTC-LTC
//param - "market" - required a string literal for the market (ex: BTC-LTC)
data class OpenOrders (
        var success: Boolean? = null,
        var message: String? = null,
        var result: List<OpenOrdersResult>? = null
)

data class OpenOrdersResult (
        var Uuid : String? = null,
        var OrderUuid : String? = null,
        var Exchange : String? = null,
        var OrderType : String? = null,
        var Quantity: Double? = null,
        var QuantityRemaining: Double? = null,
        var Limit : Double? = null,
        var CommisionPaid : Double? = null,
        var Price : Double? = null,
        var PricePerUnit : Double? = null,
        var Opened : Date? = null,
        var Closed : Date? = null,
        var CancelInitiated : Boolean? = null,
        var ImmediateOrCancel : Boolean? = null,
        var IsConditional : Boolean? = null,
        var Condition : Any? = null,
        var ConditionTarget : Any? = null
)

//All Balances = https://bittrex.com/api/v1.1/account/getbalances?apikey=API_KEY
//Specific balance = https://bittrex.com/api/v1.1/account/getbalance?apikey=API_KEY&currency=BTC
//param(Specific balance) - "currency" required a string literal for the currency (ex: LTC)
data class AccountBalance (
        var success: Boolean? = null,
        var message: String? = null,
        var result: List<AccountBalanceResult>? = null
)

data class SpecificAccountBalance (
        var success: Boolean? = null,
        var message: String? = null,
        var result: AccountBalanceResult? = null
)

data class AccountBalanceResult (
        var Currency: String? = null,
        var Balance : Double? = null,
        var Available : Double? = null,
        var Pending : Double? = null,
        var CryptoAddress : String? = null,
        var Requested: Boolean? = null,
        var Uuid: String? = null
)

//https://bittrex.com/api/v1.1/account/getdepositaddress?apikey=API_KEY&currency=VTC
//param - "currency" required a string literal for the currency (ex: LTC)
data class DepositAddress (
        var success: Boolean? = null,
        var message: String? = null,
        var result: DepositAddressResult? = null
)

data class DepositAddressResult (
        var Currency :String? = null,
        var Address : String? = null
)

//https://bittrex.com/api/v1.1/account/withdraw?apikey=API_KEY&currency=EAC&quantity=20.40&address=EAC_ADDRESS
//param - "currency" - required a string literal for the currency (ie. BTC)
//param - "quantity" - required the quantity of coins to withdraw
//param - "address" - required he address where to send the funds.
//param - "paymentid" - optional used for CryptoNotes/BitShareX/Nxt optional field (memo/paymentid)
data class Withdraw (
        var success: Boolean? = null,
        var message: String? = null,
        var result: WithdrawResult? = null
)

data class WithdrawResult (
        var Uuid: String? = null
)

//https://bittrex.com/api/v1.1/account/getorder&uuid=0cb4c4e4-bdc7-4e13-8c13-430e587d2cc1
//param - "uuid" required uuid of buy or sell order
data class SingleOrder (
        var success: Boolean? = null,
        var message: String? = null,
        var result: SingleOrderResult? = null
)

data class SingleOrderResult (
        var Uuid : String? = null,
        var OrderUuid : String? = null,
        var Exchange : String? = null,
        var Type : String? = null,
        var Quantity: Double? = null,
        var QuantityRemaining: Double? = null,
        var Limit : Double? = null,
        var Reserved : Double? = null,
        var ReserveRemaining : Double? = null,
        var CommissionReserved : Double? = null,
        var CommissionReserveRemaining : Double? = null,
        var CommissionPaid: Double? = null,
        var Price : Double? = null,
        var PricePerUnit : Double? = null,
        var Opened : Date? = null,
        var Closed : Date? = null,
        var IsOpen : Boolean? = null,
        var Sentinel: String? = null,
        var CancelInitiated : Boolean? = null,
        var ImmediateOrCancel : Boolean? = null,
        var IsConditional : Boolean? = null,
        var Condition : Any? = null,
        var ConditionTarget : Any? = null
)

//https://bittrex.com/api/v1.1/account/getorderhistory
//param - "market" - required a string literal for the market (ex: BTC-LTC)
data class OrderHistory (
        var success: Boolean? = null,
        var message: String? = null,
        var result: List<OrderHistoryResult>? = null
)

data class OrderHistoryResult (
        var OrderUuid : String? = null,
        var Exchange : String? = null,
        var TimeStamp: Date? = null,
        var OrderType : String? = null,
        var Limit : Double? = null,
        var Quantity: Double? = null,
        var QuantityRemaining: Double? = null,
        var Commision : Double? = null,
        var Price : Double? = null,
        var PricePerUnit : Double? = null,
        var IsConditional : Boolean? = null,
        var Condition : Any? = null,
        var ConditionTarget : Any? = null,
        var ImmediateOrCancel : Boolean? = null
)

//Withdrawal = https://bittrex.com/api/v1.1/account/getwithdrawalhistory?currency=BTC
//Deposit = https://bittrex.com/api/v1.1/account/getdeposithistory?currency=BTC
//param - "currency" - required a string literal for the currency (ie. BTC)
data class TransferHistory (
        var success: Boolean? = null,
        var message: String? = null,
        var result: List<TransferHistoryResult>? = null
)

data class TransferHistoryResult (
        var PaymentUuid : String? = null,
        var Currency: String? = null,
        var Amount : Double? = null,
        var Address : String? = null,
        var Opened: Date? = null,
        var Authoried: Boolean? = null,
        var PendingPayment: Boolean? = null,
        var TxCost: Double? = null,
        var TxId: String? = null,
        var Canceled: Boolean? = null,
        var InvalidAddress : Boolean? = null
)