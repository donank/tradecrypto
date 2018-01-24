package com.donank.tradecrypto.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.donank.tradecrypto.Dagger.MainApplication
import com.donank.tradecrypto.Fragments.Dashboard
import com.donank.tradecrypto.R
import donank.tradecrypto.tradecrypto.Common.showFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MainApplication).component.inject(this)
        showFragment(
                Fragment.instantiate(
                        this,
                        Dashboard::class.java.name
                ),
                addToBackStack = false)
    }

    private fun showFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        fragment.showFragment(container = R.id.fragment_container,
                fragmentManager = supportFragmentManager,
                addToBackStack = addToBackStack)
    }
}
