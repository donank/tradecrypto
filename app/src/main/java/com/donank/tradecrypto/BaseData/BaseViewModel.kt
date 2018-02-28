package com.donank.tradecrypto.BaseData

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.donank.tradecrypto.BaseApi.BaseRepository
import com.donank.tradecrypto.BaseData.Models.TrackedCurrency
import javax.inject.Inject

//ViewModel autoupdate ui when data is changed
class BaseViewModel : ViewModel() {
    @Inject lateinit var baseRepository: BaseRepository
    private var currs: MutableLiveData<List<TrackedCurrency>>? = null
    fun getCurrs(): LiveData<List<TrackedCurrency>>{
        if(currs == null){
            currs = MutableLiveData<List<TrackedCurrency>>()
            loadCurrs()
        }
        return currs as MutableLiveData<List<TrackedCurrency>>
    }

    private fun loadCurrs(){
           //todo load data from repo

    }
}