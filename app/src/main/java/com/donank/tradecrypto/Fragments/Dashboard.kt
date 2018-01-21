package com.donank.tradecrypto.Fragments


import android.databinding.ObservableArrayList
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.donank.tradecrypto.Api.ApiHelper
import com.donank.tradecrypto.BR
import com.donank.tradecrypto.Dagger.MainApplication
import com.donank.tradecrypto.Data.DashboardModel
import com.donank.tradecrypto.Data.TrackedCurrencies
import com.donank.tradecrypto.R
import com.donank.tradecrypto.databinding.ItemHoldingBinding
import com.github.nitrico.lastadapter.LastAdapter
import kotlinx.android.synthetic.main.dashboard_layout_1.*
import javax.inject.Inject

/**
 * Created by donank on 26/12/17.
 */
class Dashboard : Fragment(){

    @Inject lateinit var apiHelper: ApiHelper
    val trackedCurrencies = listOf(DashboardModel())

    private val holdings = ObservableArrayList<DashboardModel>()
    private val lastAdapter: LastAdapter by lazy { initLastAdapter() }

    fun initLastAdapter() : LastAdapter {
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
        trackedCurrencies.forEach {
            apiHelper.getTickerPrice(it.currency, it.exchange)
            holdings.clear()
            holdings.add(it)
        }

    }

    override fun onResume() {
        super.onResume()
        activity!!.title = "Dashboard"
    }
}