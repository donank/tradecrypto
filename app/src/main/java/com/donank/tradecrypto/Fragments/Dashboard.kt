package com.donank.tradecrypto.Fragments


import android.databinding.ObservableArrayList
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.donank.tradecrypto.Api.ApiHelper
import com.donank.tradecrypto.BR
import com.donank.tradecrypto.Dagger.MainApplication
import com.donank.tradecrypto.Data.Dao.TrackedCurrencyDao
import com.donank.tradecrypto.Data.Models.DashboardModel
import com.donank.tradecrypto.Data.Models.Exchanges
import com.donank.tradecrypto.Data.Models.TrackedCurrency
import com.donank.tradecrypto.R
import com.donank.tradecrypto.databinding.ItemHoldingBinding
import com.github.nitrico.lastadapter.LastAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.dashboard_layout_1.*
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking
import javax.inject.Inject

/**
 * Created by donank on 26/12/17.
 */
class Dashboard : Fragment() {

    lateinit var apiHelper: ApiHelper

    @Inject lateinit var trCurrencyDao : TrackedCurrencyDao

    private val holdings = ObservableArrayList<DashboardModel>()
    private val lastAdapter: LastAdapter by lazy { initLastAdapter() }

    fun initLastAdapter(): LastAdapter {
        return LastAdapter(holdings, BR.item)
                .map<DashboardModel, ItemHoldingBinding>(R.layout.item_holding)
                .into(dashboard_recycler_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity!!.application as MainApplication).component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.dashboard_layout_1, container, false)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dashboard_recycler_view.adapter = lastAdapter
        dashboard_recycler_view.layoutManager = LinearLayoutManager(activity)
        async {
            trCurrencyDao.insertCurrency(TrackedCurrency("BTC-LTC",Exchanges.BITTREX.toString()))
            trCurrencyDao.insertCurrency(TrackedCurrency("BTC_ETH",Exchanges.POLONIEX.toString()))
            getData()

        }

            trCurrencyDao.getAllCurrencies().subscribe { test_tv.text = it[0].ticker }


    }

    fun getData(){
        async {
            trCurrencyDao.getAllCurrencies()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        it.forEach {
                            async {
                                val dash = apiHelper.getTickerPrice(it.ticker, it.exchange)
                                holdings.clear()
                                holdings.add(dash)
                            }
                        }
                    }.dispose()
        }
    }

    override fun onResume() {
        super.onResume()
        activity!!.title = "Dashboard"
    }
}