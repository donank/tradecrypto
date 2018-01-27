package com.donank.tradecrypto.Fragments


import android.databinding.ObservableArrayList
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.donank.tradecrypto.BR
import com.donank.tradecrypto.Dagger.MainApplication
import com.donank.tradecrypto.Data.Dao.TrackedCurrencyDao
import com.donank.tradecrypto.Data.Models.DashboardModel
import com.donank.tradecrypto.R
import com.donank.tradecrypto.databinding.ItemHoldingBinding
import com.github.nitrico.lastadapter.LastAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.dashboard_layout_1.*
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

/**
 * Created by donank on 26/12/17.
 */
class Dashboard : Fragment() {

    @Inject lateinit var trackedCurrencyDao: TrackedCurrencyDao

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
        dashboard_recycler_view.layoutManager = LinearLayoutManager(context)

        launch {
            getDataFromDb()
        }

        refresh_dashboard.setOnRefreshListener {
            //todo fix the never ending progressbar
            Log.d("OnRefresh Call", "getData")
            getDataFromDb()
        }

    }

    fun getDataFromDb() {
        //todo fix view issues
        Log.d("getDataFromDb", "")
        trackedCurrencyDao.getAllCurrencies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    holdings.clear()
                    holdings.addAll(it)
                    Log.d("holdings", "${holdings.size}")
                }, {
                    progressbar.visibility = View.GONE
                    refresh_dashboard.visibility = View.GONE
                },{
                    progressbar.visibility = View.GONE
                    refresh_dashboard.visibility = View.GONE
                })
    }


    override fun onResume() {
        super.onResume()
        activity!!.title = "Dashboard"
    }
}